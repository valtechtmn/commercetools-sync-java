package com.commercetools.sync.benchmark.products;


import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ProductSyncBenchmark {
    @Test
    @SuppressWarnings("PMD")
    public void product_benchmark() {
        try {
            replaceInFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void  replaceInFile() throws IOException {
        final Path path = Paths.get("docs/BENCHMARKS.md");
        final Charset charset = StandardCharsets.UTF_8;
        final String search = "#test";
        final String replacement = "auto injected from product benchmark";

        String content = new String(Files.readAllBytes(path), charset);
        content = content.replaceAll(search, replacement);
        Files.write(path, content.getBytes(charset));
    }
}
