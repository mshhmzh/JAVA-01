import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> clzz = new HelloClassLoader().findClass("Hello");
            Object instance = clzz.newInstance();
            clzz.getMethod("hello").invoke(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] data = prepareClazzData();
        return defineClass(name, data, 0, data.length);
    }

    private byte[] prepareClazzData() throws ClassNotFoundException {
        //use absolute path
        String filename = "/home/ivanling/Documents/demoProject/javaTraning/src/Hello.xlass";
        byte[] data;
        try {
            data = loadFileData(filename);
        } catch (IOException e) {
            e.printStackTrace();
            throw  new ClassNotFoundException("xlass file not found");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(255 - data[i]);
        }
        return data;
    }

    public static byte[] loadFileData(String fileName) throws IOException {
        File file = new File(fileName);
        byte[] bytes = new byte[(int) file.length()];
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read(bytes);
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
        return bytes;
    }


}