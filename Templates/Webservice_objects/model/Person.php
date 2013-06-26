<?php 
class Person{

    private $id;
    private $name;

    function __construct($id, $name) {
        $this->id = $id;
        $this->name = $name;
    }

    public static function get($object) {
        if (property_exists($object, "Person")) {
            $object = $object->Person;
        }
        return new Person($object->id, $object->name);
    }

    // <editor-fold defaultstate="collapsed" desc="Get and Set">
    public function getId() {
        return $this->id;
    }

    public function setId($id) {
        $this->id = $id;
    }

    public function getName() {
        return $this->name;
    }

    public function setName($name) {
        $this->name = $name;
    }

    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="CRUD">
    public static function create($Person) {
        $id = mysqli_real_escape_string($Person->getId());
        $name = mysqli_real_escape_string($Person->getName());
        return MysqlDBC::getInstance()->insert(
                        "INSERT INTO `person` (`id` ,`name`) VALUES ('$id' ,'$name')"
        );
    }

    public static function modify($Person) {
        $id = mysqli_real_escape_string($Person->getId());
        $name = mysqli_real_escape_string($Person->getName());
        return MysqlDBC::getInstance()->insert(
                        "UPDATE `person` SET `name` = '$name' WHERE `id` = '$id'"
        );
    }

    public static function delete($Person) {
        $id = mysqli_real_escape_string($Person->getId());
        return MysqlDBC::getInstance()->delete(
                        "DELETE FROM `person` WHERE `id` = '$id' LIMIT 1"
        );
    }

    public static function getList($page, $count, $filters) {
        // <editor-fold defaultstate="collapsed" desc="Limit">
        $limit = "";
        if ($count > 0 && $page >= 0) {
            $lowerLimit = $page * $count;
            $limit = " LIMIT $lowerLimit, $count";
        }
        // </editor-fold>
        // <editor-fold defaultstate="collapsed" desc="Where">
        $where = "";
        if (is_array($filters) && count($filters) > 0) {
            $where = " WHERE ";
            $keys = array_keys($filters);
            for ($i = 0; $i < count($keys); $i++) {
                $where .= "person." . $keys[$i] . " = " . $filters[$keys[$i]];
                if ($i < count($keys) - 1) {
                    $where .= " AND ";
                }
            }
        }
        // </editor-fold>
        $result = MysqlDBC::getInstance()->getResult("SELECT * FROM `person` $where $limit");
        $list = array();
        while ($row = $result->fetch_object()) {
            $Entity = Person::get($row);
            array_push($list, $Entity);
        }
        return $list;
    }

    // </editor-fold>

    public function toArray() {
        return array(
            'id' => $this->getId(),
            'name' => $this->getName()
        );
    }

}

?>
