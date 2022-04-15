package com.example.dong.minio;

import io.minio.GetObjectArgs;
import io.minio.MinioClient;
import io.minio.errors.*;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class GetUrl {
    public static void main(String[] args) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://10.0.96.49:9000")
                        .credentials("admin", "admin123456")
                        .build();
        //http://10.0.96.49:9000/asiatrip/test.png
        minioClient.getObject(GetObjectArgs.builder().bucket("asiatrip").object("test.png").build());
    }

}
