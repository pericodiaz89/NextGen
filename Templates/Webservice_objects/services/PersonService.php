<?php
include ('Service.php');
define('Person', 'Person');

/**
 * Description of PersonService
 *
 * @author Rodrigo
 */
class PersonService extends Service {

    public function includeSpecificFiles() {
        include('../model/Person.php');
    }

    public function create() {
        if (checkParam(Person)) {
            $Person = $this->getPerson();
            return Person::create($Person);
        }
    }

    public function modify() {
        if (checkParam(Person)) {
            $Person = $this->getPerson();
            return Person::modify($Person);
        }
    }

    public function delete() {
        if (checkParam(Person)) {
            $Person = $this->getPerson();
            return Person::delete($Person);
        }
    }

    public function get() {
        $filters = array();
        if (checkParam('filters')) {
            $filters = json_decode($_REQUEST['filters']);
        }
        if (checkParams('page', 'count')) {
            $A = (Person::getList($_REQUEST['page'], $_REQUEST['count'], $filters));
            return ArrayHelper::toArray($A);
        } else {
            return getErrorArray(03, "Parameters missing (page, count)");
        }
    }

    public function getPerson() {
        return Person::get(json_decode($_REQUEST[Person]));
    }

}

new PersonService();
?>
