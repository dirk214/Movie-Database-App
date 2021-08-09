package com.example.dirk2.moviedatabase;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by dirk2 on 3/18/2018.
 */

public class ListGenerator {


    public static void main(String[] args) throws Exception {
        Movie[] movies = ListGenerator.getMoviesVote();
        for(int i = 0; i < 20; i++) {
            System.out.println(movies[i].toString());
        }
    }

    public static Movie[] getMoviesAlpha() throws  Exception {
        ListGenerator gener = new ListGenerator();
        return gener.sortAlpha();
    }

    public static Movie[] getMoviesVote() throws  Exception {
        ListGenerator gener = new ListGenerator();
        return gener.sortVote();
    }

    public static Movie[] getMovies() throws Exception {
        ListGenerator gener = new ListGenerator();
        return gener.generateList();
    }


    public Movie[] generateList() throws Exception {
        String url = "https://api.themoviedb.org/3/movie/now_playing?page=1&language=en-US&api_key=1772c01dd0ca4b014efcce26438fccb7";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        Scanner scanner = new Scanner(response.toString());
        String responded = response.toString();
        responded = responded.substring(13);
        String[] ArrayResp = responded.split(",\"|,\\{" );
        for(int i = 0; i < ArrayResp.length; i++) {
            if (i != 0 && !ArrayResp[i].startsWith("\""))
                ArrayResp[i] = '"' + ArrayResp[i];
            if(ArrayResp[i].contains("release_date")) {

            }
        }
        Movie[] listOfMovies = new Movie[20];
        int g = 0;
        int i = 0;
        while(g != 20) {
            Movie movie = new Movie(Integer.parseInt(ArrayResp[i].substring(13)),
                    Integer.parseInt(ArrayResp[i + 1].substring(5)), Boolean.parseBoolean(ArrayResp[i + 2].substring(8)),
                    Double.parseDouble(ArrayResp[i + 3].substring(15)), ArrayResp[i + 4].substring(8),
                    Double.parseDouble(ArrayResp[i + 5].substring(13)), ArrayResp[i + 6].substring(14),
                    ArrayResp[i + 7].substring(20), ArrayResp[i + 8].substring(17), ArrayResp[i + 9].substring(12),
                    ArrayResp[i + 10].substring(16), Boolean.parseBoolean(ArrayResp[i + 11].substring(8)),
                    ArrayResp[i + 12].substring(11), ArrayResp[i+13].substring(14));
            listOfMovies[g] = movie;
            g++;
            i+=14;
        }
        return listOfMovies;

    }

    public class MovieComparator implements Comparator<Movie> {
        public int compare(Movie movie1, Movie movie2) {
            String movieTitle1 = movie1.getTitle().toUpperCase();
            String movieTitle2 = movie2.getTitle().toUpperCase();
            return movieTitle1.compareTo(movieTitle2);
        }
    };

    public Movie[] sortAlpha() throws Exception {
        Movie[] movies = ListGenerator.getMovies();
        Arrays.sort(movies, new MovieComparator());
        return movies;
    }

    public Movie[] sortVote() throws Exception {
        Movie[] movies = ListGenerator.getMovies();
        Arrays.sort(movies);
        return movies;
    }


}
