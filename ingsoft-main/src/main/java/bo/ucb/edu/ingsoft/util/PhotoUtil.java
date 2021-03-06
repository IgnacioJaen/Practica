package bo.ucb.edu.ingsoft.util;

import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PhotoUtil {
    //imagen guardada en el local cn el path
    private Path root;


    public String upload(MultipartFile file,String path){
        root=Paths.get(path);

        try{
            String nombre=genName()+extension(file.getOriginalFilename());
            Files.copy(file.getInputStream(),this.root.resolve(nombre));
            return this.root.getFileName()+"/"+nombre;
        }
        catch(Exception e){
            throw new RuntimeException("Could not store the file. Error: " + e);
        }
    }
    //saca donde termine la imagen
    public String extension(String nombreArchivo){
        String[] partesNombre=nombreArchivo.split("\\.");
        if(partesNombre.length>1){
            return "."+partesNombre[1];
        }
        else{
            return  "";
        }
    }
    //numero aleatatorio para que no sea lo misma
    public String genName(){

        String chars ="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String autoId = "";
        for (int i = 0; i < 20; i++) {
            autoId += chars.charAt((int) Math.floor(Math.random() * chars.length()));
        }

        return autoId;
    }
}
