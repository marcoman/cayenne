package org.apache.cayenne.testdo.cay_2641.auto;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.cayenne.Fault;
import org.apache.cayenne.PersistentObject;
import org.apache.cayenne.exp.property.EntityProperty;
import org.apache.cayenne.exp.property.NumericIdProperty;
import org.apache.cayenne.exp.property.PropertyFactory;
import org.apache.cayenne.exp.property.SelfProperty;
import org.apache.cayenne.exp.property.StringProperty;
import org.apache.cayenne.testdo.cay_2641.ArtistLazy;
import org.apache.cayenne.testdo.cay_2641.PaintingLazy;

/**
 * Class _PaintingLazy was generated by Cayenne.
 * It is probably a good idea to avoid changing this class manually,
 * since it may be overwritten next time code is regenerated.
 * If you need to make any customizations, please use subclass.
 */
public abstract class _PaintingLazy extends PersistentObject {

    private static final long serialVersionUID = 1L;

    public static final SelfProperty<PaintingLazy> SELF = PropertyFactory.createSelf(PaintingLazy.class);

    public static final NumericIdProperty<Integer> ID_PK_PROPERTY = PropertyFactory.createNumericId("ID", "PaintingLazy", Integer.class);
    public static final String ID_PK_COLUMN = "ID";

    public static final StringProperty<String> NAME = PropertyFactory.createString("name", String.class);
    public static final EntityProperty<ArtistLazy> ARTIST = PropertyFactory.createEntity("artist", ArtistLazy.class);

    protected Object name;

    protected Object artist;

    public void setName(String name) {
        beforePropertyWrite("name", this.name, name);
        this.name = name;
    }

    public String getName() {
        beforePropertyRead("name");
        if(this.name instanceof Fault) {
            this.name = ((Fault) this.name).resolveFault(this, "name");
        }
        return (String)this.name;
    }

    public void setArtist(ArtistLazy artist) {
        setToOneTarget("artist", artist, true);
    }

    public ArtistLazy getArtist() {
        return (ArtistLazy)readProperty("artist");
    }

    @Override
    public Object readPropertyDirectly(String propName) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch(propName) {
            case "name":
                return this.name;
            case "artist":
                return this.artist;
            default:
                return super.readPropertyDirectly(propName);
        }
    }

    @Override
    public void writePropertyDirectly(String propName, Object val) {
        if(propName == null) {
            throw new IllegalArgumentException();
        }

        switch (propName) {
            case "name":
                this.name = val;
                break;
            case "artist":
                this.artist = val;
                break;
            default:
                super.writePropertyDirectly(propName, val);
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        writeSerialized(out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        readSerialized(in);
    }

    @Override
    protected void writeState(ObjectOutputStream out) throws IOException {
        super.writeState(out);
        out.writeObject(this.name);
        out.writeObject(this.artist);
    }

    @Override
    protected void readState(ObjectInputStream in) throws IOException, ClassNotFoundException {
        super.readState(in);
        this.name = in.readObject();
        this.artist = in.readObject();
    }

}