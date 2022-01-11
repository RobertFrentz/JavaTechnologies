package com.lab9EEjava.JavaLab9EE.secure;

import io.vertx.ext.auth.JWTOptions;
import io.vertx.ext.auth.PubSecKeyOptions;
import io.vertx.ext.auth.jwt.JWTAuth;
import io.vertx.ext.auth.jwt.JWTAuthOptions;

import javax.annotation.PostConstruct;
import javax.annotation.security.PermitAll;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.UUID;

@Path("/secured")
@ApplicationScoped
public class TestSecureController {

    private String key;

    @PostConstruct
    public void init() {
        key = readPemFile();
    }

    @GET
    @PermitAll
    @Path("/jwt")
    public String getJWT() {
        if (key == null) {
            throw new WebApplicationException("Unable to read privateKey.pem", 500);
        }
        /*        WebTarget target = ClientBuilder.newClient().target("http://localhost:8180/data/protected");
        Response response = target.request().header("authorization", "Bearer " + jwt).buildGet().invoke();*/
        return generateJWT(key);
    }

    private static String generateJWT(String key) {
        JWTAuth provider = JWTAuth.create(null, new JWTAuthOptions()
                .addPubSecKey(new PubSecKeyOptions()
                        .setAlgorithm("RS256")
                        .setSecretKey(key)
                ));

        MPJWTToken token = new MPJWTToken();
        token.setAud("targetService");
        token.setIss("RobertF");  // Must match the expected issues configuration values
        token.setJti(UUID.randomUUID().toString());
        token.setSub("RobertFrentz");  // Sub is required for WildFly Swarm
        token.setUpn("RobertFrentz");
        token.setIat(System.currentTimeMillis());
        token.setExp(System.currentTimeMillis() + 3600000); // 1 hour valid
        token.addAdditionalClaims("test-custom-value", "Test custom specific value");
        token.setGroups(Arrays.asList("admin", "author", "reviewer"));

        return provider.generateToken(new io.vertx.core.json.JsonObject().mergeIn(token.toJSONString()), new JWTOptions().setAlgorithm("RS256"));
    }

    // NOTE:   Expected format is PKCS#8 (BEGIN PRIVATE KEY) NOT PKCS#1 (BEGIN RSA PRIVATE KEY)
    // See gencerts.sh
    private static String readPemFile() {
        StringBuilder sb = new StringBuilder(8192);
        try (BufferedReader is = new BufferedReader(
                new InputStreamReader(
                        TestSecureController.class.getResourceAsStream("/privateKey.pem"), StandardCharsets.US_ASCII))) {
            String line;
            while ((line = is.readLine()) != null) {
                if (!line.startsWith("-")) {
                    sb.append(line);
                    sb.append('\n');
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
