package com.petstoreapp.petapp.Services;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import javax.swing.plaf.multi.MultiButtonUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.petstoreapp.petapp.FileStoragePropertie;
import com.petstoreapp.petapp.Entities.Product;
import com.petstoreapp.petapp.Repository.ProductRepository;

@Service
public class FileService {
    // This variable will contain the path of the folder
    // where the files has to be uploaded and downloaded
    private final Path rootoaction;

    public FileService(FileStoragePropertie properties) {
        // Here we are initialzing the value for the rootlocation
        this.rootoaction = Paths.get(properties.getUploadDir());

    }

    @Autowired
    private ProductRepository productRepository;

    public String fileUpload(Integer id, MultipartFile file) {

        // First we are checking if the product with id provided exists in the
        // database or not because we will do uploading only for existing products
        Product foundProduct = this.productRepository.findById(id).orElse(null);
        try {
            if (foundProduct == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product with this id does not exist");
            } else {

                // File which is coming along with the request we will read that file
                // using InputStream
                // and then write the file in the uploads folder
                // basically we copy the request file and paste it in the uploads folder

                // This statement is specifying what should be the name of the file in the
                // uploads folder. It should be same as that of the request file
                Path destionationFile = this.rootoaction.resolve(file.getOriginalFilename());

                // Setting the inputstrem to read the file coming in the request
                InputStream inputStream = file.getInputStream();

                // now we will copy the file and write in the destination
                Files.copy(inputStream, destionationFile, StandardCopyOption.REPLACE_EXISTING);

                // ServletUriComponentsBuilder.fromCurrentContextPath() ==>
                // will give http://localhost:8080
                String imageUrl = ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/products/download/")
                        .path(file.getOriginalFilename())
                        .toUriString();

                // we will update imageUrl for the product
                foundProduct.setImgUrl(imageUrl);
                // saving in the database
                this.productRepository.save(foundProduct);

                return "File Upoaded Successfully";

            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                    "Server facing some issue  in uploading file");

        }

    }

    public Resource fileDownload(String fileName){
        Path filPath = rootoaction.resolve(fileName);
    try{
        Resource downloadedFile = new UrlResource(filPath.toUri());
        return downloadedFile;
    }
    catch(Exception e ){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"File cannot be downloaded");
    }
    }

}
