//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class deleted_methods {
//    private static void createCity(String name, String state, int population) {
//        try {
//            URL url = new URL(BASE_URL + "/cities");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String cityJson = String.format("{\"name\":\"%s\", \"state\":\"%s\", \"population\":%d}", name, state, population);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = cityJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                System.out.println("Created city with ID: " + response.toString());
//            } else {
//                System.out.println("POST request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void updateCity(int id, String name, String state, int population) {
//        try {
//            URL url = new URL(BASE_URL + "/cities/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("PUT");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String cityJson = String.format("{\"id\":%d, \"name\":\"%s\", \"state\":\"%s\", \"population\":%d}", id, name, state, population);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = cityJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Updated city with ID: " + id);
//            } else {
//                System.out.println("PUT request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void deleteCity(int id) {
//        try {
//            URL url = new URL(BASE_URL + "/cities/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("DELETE");
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Deleted city with ID: " + id);
//            } else {
//                System.out.println("DELETE request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void createPassenger(String firstName, String lastName, String phoneNumber) {
//        try {
//            URL url = new URL(BASE_URL + "/passengers");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String passengerJson = String.format("{\"firstName\":\"%s\", \"lastName\":\"%s\", \"phoneNumber\":\"%s\"}", firstName, lastName, phoneNumber);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = passengerJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                System.out.println("Created passenger with ID: " + response.toString());
//            } else {
//                System.out.println("POST request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void updatePassenger(int id, String firstName, String lastName, String phoneNumber) {
//        try {
//            URL url = new URL(BASE_URL + "/passengers/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("PUT");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String passengerJson = String.format("{\"id\":%d, \"firstName\":\"%s\", \"lastName\":\"%s\", \"phoneNumber\":\"%s\"}", id, firstName, lastName, phoneNumber);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = passengerJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Updated passenger with ID: " + id);
//            } else {
//                System.out.println("PUT request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void deletePassenger(int id) {
//        try {
//            URL url = new URL(BASE_URL + "/passengers/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("DELETE");
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Deleted passenger with ID: " + id);
//            } else {
//                System.out.println("DELETE request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void createAirport(String name, String code) {
//        try {
//            URL url = new URL(BASE_URL + "/airports");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String airportJson = String.format("{\"name\":\"%s\", \"code\":\"%s\"}", name, code);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = airportJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                System.out.println("Created airport with ID: " + response.toString());
//            } else {
//                System.out.println("POST request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void updateAirport(int id, String name, String code) {
//        try {
//            URL url = new URL(BASE_URL + "/airports/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("PUT");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String airportJson = String.format("{\"id\":%d, \"name\":\"%s\", \"code\":\"%s\"}", id, name, code);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = airportJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Updated airport with ID: " + id);
//            } else {
//                System.out.println("PUT request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void deleteAirport(int id) {
//        try {
//            URL url = new URL(BASE_URL + "/airports/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("DELETE");
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Deleted airport with ID: " + id);
//            } else {
//                System.out.println("DELETE request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void createAircraft(String type, String airlineName, int numberOfPassengers) {
//        try {
//            URL url = new URL(BASE_URL + "/aircraft");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String aircraftJson = String.format("{\"type\":\"%s\", \"airlineName\":\"%s\", \"numberOfPassengers\":%d}", type, airlineName, numberOfPassengers);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = aircraftJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//                String inputLine;
//                StringBuilder response = new StringBuilder();
//
//                while ((inputLine = in.readLine()) != null) {
//                    response.append(inputLine);
//                }
//                in.close();
//
//                System.out.println("Created aircraft with ID: " + response.toString());
//            } else {
//                System.out.println("POST request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void updateAircraft(int id, String type, String airlineName, int numberOfPassengers) {
//        try {
//            URL url = new URL(BASE_URL + "/aircraft/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("PUT");
//            conn.setRequestProperty("Content-Type", "application/json; utf-8");
//            conn.setDoOutput(true);
//
//            String aircraftJson = String.format("{\"id\":%d, \"type\":\"%s\", \"airlineName\":\"%s\", \"numberOfPassengers\":%d}", id, type, airlineName, numberOfPassengers);
//            try (OutputStream os = conn.getOutputStream()) {
//                byte[] input = aircraftJson.getBytes("utf-8");
//                os.write(input, 0, input.length);
//            }
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Updated aircraft with ID: " + id);
//            } else {
//                System.out.println("PUT request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void deleteAircraft(int id) {
//        try {
//            URL url = new URL(BASE_URL + "/aircraft/" + id);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("DELETE");
//
//            int responseCode = conn.getResponseCode();
//            if (responseCode == 200) {
//                System.out.println("Deleted aircraft with ID: " + id);
//            } else {
//                System.out.println("DELETE request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
