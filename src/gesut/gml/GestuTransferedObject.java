package gesut.gml;

import gesut.repository.generic.ObiektGESUT;

public class GestuTransferedObject extends ObiektGESUT {
    private GmlObjectTypes transferedObjectName;

    public GmlObjectTypes getTransferedObjectName() {
        return transferedObjectName;
    }

    public void setTransferedObjectName(GmlObjectTypes transferedObjectName) {
        this.transferedObjectName = transferedObjectName;
    }
}
