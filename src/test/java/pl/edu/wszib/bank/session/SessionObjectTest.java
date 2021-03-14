package pl.edu.wszib.bank.session;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SessionObjectTest {

    @Test
    void getInfo() {
        SessionObject sessionObject = new SessionObject();
        String info = "INFO";

        Assert.assertNull(sessionObject.getInfo());
        sessionObject.setInfo(info);
        Assert.assertEquals(info, sessionObject.getInfo());
        Assert.assertNull(sessionObject.getInfo());
    }
}