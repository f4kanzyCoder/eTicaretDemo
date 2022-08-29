package eTicaretDemo.core.concrates;

import eTicaretDemo.core.abstracts.GoogleMailService;
import eTicaretDemo.google.GoogelMailManager;

public class GoogleMailManagerAdapter implements GoogleMailService {
    @Override
    public void registerToSystem(String message) {
        GoogelMailManager manager = new GoogelMailManager();
        manager.registerToSystem(message);
    }
}
