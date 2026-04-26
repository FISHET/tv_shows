import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Collections;
import java.util.List;

public class Main {

    final static String BASE_URL = "https://jsonmock.hackerrank.com/api/tvseries/search/";

    public static void main(String[] args) {
        // get total pages so we know how many loops to do
        int totalPages = getTotalPages();

        // create an empty JSON Array to add our series to
        JsonArray tvSeriesArray = new JsonArray();

        int page = 1;

        // now query each paginated API response to build our unordered array
        while (page <= totalPages) {

            queryApi(page, tvSeriesArray);

            page++;
        }

        // then order the list
        List<JsonElement> orderedList = orderList(tvSeriesArray);

        // then check for our Genre
//        String selectedGenre = "Action";
        String selectedGenre = args[0];

        for (JsonElement series : orderedList) {
            if (series.getAsJsonObject().get("genre").getAsString().contains(selectedGenre)) {
                System.out.printf("The highest rated %s series is: %s%n", selectedGenre, series.getAsJsonObject().get("name"));
                break;
            }
        }
    }

    private static int getTotalPages() {
        Response apiResponse = RestAssured.get(BASE_URL);
        int totalPages = apiResponse.getBody().jsonPath().getInt("total_pages");
        System.out.println("Number of pages: " + totalPages);

        return totalPages;
    }

    private static void queryApi(int page, JsonArray tvSeries) {
        Response apiResponse = RestAssured.get(BASE_URL + "?page=" + page);

        int apiResponseCode = apiResponse.getStatusCode();
        String apiResponseBody = apiResponse.getBody().asString();

        System.out.printf("API Response for page %s: %s%n", page, apiResponseCode);

        JsonObject jsonResponse = new Gson().fromJson(apiResponseBody, JsonObject.class);
        JsonArray tvSeriesThisPage = jsonResponse.getAsJsonArray("data");

        for (JsonElement jsonElement : tvSeriesThisPage) {
            tvSeries.add(jsonElement.getAsJsonObject());
        }
    }

    private static List<JsonElement> orderList(JsonArray unorderedListOfSeries) {
        List<JsonElement> seriesList = unorderedListOfSeries.asList();

        Collections.sort(seriesList, (a, b) -> {
            double imdbRatingA = a.getAsJsonObject().get("imdb_rating").getAsDouble();
            double imdbRatingB = b.getAsJsonObject().get("imdb_rating").getAsDouble();
            return Double.compare(imdbRatingB, imdbRatingA);
        });

        return seriesList;
    }
}
