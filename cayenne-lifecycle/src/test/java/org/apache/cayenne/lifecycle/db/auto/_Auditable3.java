package org.apache.cayenne.lifecycle.db.auto;

import java.util.List;

import org.apache.cayenne.CayenneDataObject;
import org.apache.cayenne.exp.Property;
import org.apache.cayenne.lifecycle.db.Auditable4;

/**
 * Class _Auditable3 was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _Auditable3 extends CayenneDataObject {

    private static final long serialVersionUID = 1L; 

    public static final String ID_PK_COLUMN = "ID";

    public static final Property<String> CHAR_PROPERTY1 = new Property<String>("charProperty1");
    public static final Property<String> CHAR_PROPERTY2 = new Property<String>("charProperty2");
    public static final Property<List<Auditable4>> AUDITABLE4S = new Property<List<Auditable4>>("auditable4s");

    public void setCharProperty1(String charProperty1) {
        writeProperty("charProperty1", charProperty1);
    }
    public String getCharProperty1() {
        return (String)readProperty("charProperty1");
    }

    public void setCharProperty2(String charProperty2) {
        writeProperty("charProperty2", charProperty2);
    }
    public String getCharProperty2() {
        return (String)readProperty("charProperty2");
    }

    public void addToAuditable4s(Auditable4 obj) {
        addToManyTarget("auditable4s", obj, true);
    }
    public void removeFromAuditable4s(Auditable4 obj) {
        removeToManyTarget("auditable4s", obj, true);
    }
    @SuppressWarnings("unchecked")
    public List<Auditable4> getAuditable4s() {
        return (List<Auditable4>)readProperty("auditable4s");
    }


}
