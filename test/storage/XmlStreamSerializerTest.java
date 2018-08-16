package storage;

import storage.serializer.XmlStreamSerializer;

public class XmlStreamSerializerTest extends AbstractStorageTest {

    public XmlStreamSerializerTest() {
        super(new FileStorage(STORAGE_DIR, new XmlStreamSerializer()));
    }
}
