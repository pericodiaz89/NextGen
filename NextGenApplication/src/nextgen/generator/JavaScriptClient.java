package nextgen.generator;

import nextgen.dao.FileManager;
import nextgen.model.Attribute;
import nextgen.model.Element;
import nextgen.model.Project;

/**
 *
 * @author Mateo
 */

public class JavaScriptClient extends Generator {

    private Project project;
    private String directory;
    
    
    @Override
    public void generate(Project project, String directory) throws Exception {
        this.project = project;
        this.directory = directory;
        FileManager.generateFile(directory+"/services/Service.js", createModel());;
        
    }
    
    public String createModel(){
        String js =  " // <editor-fold defaultstate=\"collapsed\" desc=\"Model\">";
        for (Element e : project.getElements()) {
            String params = "";
            String attributesInit = "";
            for (Attribute a : e.getAttributes()){
                if(!attributesInit.equals("")){
                    params += ",";
                    attributesInit += "\n";
                }
                attributesInit = String.format(attributesInit + "\t this.%s = %s", a.getName(), a.getName());
                params = String.format(params + "%s", a.getName());
            }
            js = String.format(js + "//%s"
                    + "\n\n function %s (%s){"
                    + "\n\t %s"
                    + "}", e.getName(), e.getName(), params, attributesInit);
        }
        js += "// </editor-fold>";
        return js;
    }
    
}
