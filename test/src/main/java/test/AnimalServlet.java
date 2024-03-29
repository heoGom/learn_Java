package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AnimalServlet")
public class AnimalServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    // 여기에 본인의 인증키를 넣어주세요
    private static final String API_KEY = "9tP0rrmdgYvkDyrkZFzOXRhcivDyQrpntkl/4XCMaH207D5iwNA7sDGOipABXA18dCTX9Bykv5qYyKj44fQl2g==";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // OpenAPI에서 데이터를 가져오는 부분 추가
        String apiUrl = "https://apis.data.go.kr/1543061/abandonmentPublicSrvc/abandonmentPublic";
        String queryParams = "?serviceKey=" + API_KEY + "&pageNo=1&numOfRows=1000&_type=json";
        URL url = new URL(apiUrl + queryParams);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder jsonData = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            jsonData.append(line);
        }
        reader.close();
        con.disconnect();

        // AnimalResponseParser를 사용하여 JSON 데이터 파싱
        List<Animal> animalList = AnimalResponseParser.parseJsonResponse(jsonData.toString());

        // Animal 객체 리스트를 JSP 페이지로 전달
        request.setAttribute("animalList", animalList);

        // content type 및 character encoding 설정
        response.setContentType("text/html;charset=UTF-8");

        // JSP 페이지로 forward
        request.getRequestDispatcher("/result.jsp").forward(request, response);
    }
}