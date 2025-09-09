package org.example; // パッケージはご自身の環境に合わせてください

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {
        // すべてのオリジンからのアクセスを許可
        responseContext.getHeaders().add(
                "Access-Control-Allow-Origin", "*");

        // 許可するHTTPメソッド
        responseContext.getHeaders().add(
                "Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");

        // 許可するHTTPヘッダー
        // プリフライトリクエストで許可を求められたヘッダーをそのまま返すのが一般的
        String requestHeaders = requestContext.getHeaderString("Access-Control-Request-Headers");
        if (requestHeaders != null) {
            responseContext.getHeaders().add(
                    "Access-Control-Allow-Headers", requestHeaders);
        }

        // Content-Typeヘッダーの許可（例として追加）
        responseContext.getHeaders().add(
                "Access-Control-Allow-Headers", "Content-Type");
    }
}