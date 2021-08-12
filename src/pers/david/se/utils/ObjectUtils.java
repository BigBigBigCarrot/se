package pers.david.se.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import pers.david.se.vo.CompanyVO;

public class ObjectUtils {
    /**
     * srcObject must implement java.io.Serializable
     *
     * @param srcObject
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws NotSerializableException
     */
    public static Object deepClone(Object srcObject) throws IOException, ClassNotFoundException, NotSerializableException {
        ByteArrayOutputStream byteout = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteout);
        out.writeObject(srcObject);
        ByteArrayInputStream bytein = new ByteArrayInputStream(byteout.toByteArray());
        ObjectInputStream in = new ObjectInputStream(bytein);
        return in.readObject();
    }

    public ObjectUtils() {
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        CompanyVO c1, c2;
        c1 = new CompanyVO("ms");
        c2 = (CompanyVO) ObjectUtils.deepClone(c1);
        System.out.println(c1.getCompanyName());
        c2.setCompanyName("apple");
        System.out.println(c1.getCompanyName());
        System.out.println(c2.getCompanyName());
    }

}
