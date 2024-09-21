package unitins.tp1.service.file;

import java.io.File;
import java.io.IOException;

public interface FileService {

    String salvar(String nomeArquivo, byte[] arquivo) throws IOException;

    File obter(String nomeArquivo); 
    
}
