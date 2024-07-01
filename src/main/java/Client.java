import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Client {
    private static final String BASE_URL = "http://localhost:8080";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Manage Cities");
            System.out.println("2. Manage Passengers");
            System.out.println("3. Manage Airports");
            System.out.println("4. Manage Aircraft");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    manageCities(scanner);
                    break;
                case 2:
                    managePassengers(scanner);
                    break;
                case 3:
                    manageAirports(scanner);
                    break;
                case 4:
                    manageAircraft(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageCities(Scanner scanner) {
        while (true) {
            System.out.println("Cities Menu:");
            System.out.println("1. List cities");
            System.out.println("2. Create city");
            System.out.println("3. Update city");
            System.out.println("4. Delete city");
            System.out.println("5. Return to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listEntities("/cities");
                    break;
                case 2:
                    System.out.print("Enter city name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter province: ");
                    String state = scanner.nextLine();
                    System.out.print("Enter population: ");
                    int population = scanner.nextInt();
                    createCity(name, state, population);
                    break;
                case 3:
                    System.out.print("Enter city ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new city name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new state: ");
                    String newState = scanner.nextLine();
                    System.out.print("Enter new population: ");
                    int newPopulation = scanner.nextInt();
                    updateCity(id, newName, newState, newPopulation);
                    break;
                case 4:
                    System.out.print("Enter city ID: ");
                    int cityId = scanner.nextInt();
                    deleteCity(cityId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void managePassengers(Scanner scanner) {
        while (true) {
            System.out.println("Passengers Menu:");
            System.out.println("1. List passengers");
            System.out.println("2. Create passenger");
            System.out.println("3. Update passenger");
            System.out.println("4. Delete passenger");
            System.out.println("5. Return to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listEntities("/passengers");
                    break;
                case 2:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    createPassenger(firstName, lastName, phoneNumber);
                    break;
                case 3:
                    System.out.print("Enter passenger ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new first name: ");
                    String newFirstName = scanner.nextLine();
                    System.out.print("Enter new last name: ");
                    String newLastName = scanner.nextLine();
                    System.out.print("Enter new phone number: ");
                    String newPhoneNumber = scanner.nextLine();
                    updatePassenger(id, newFirstName, newLastName, newPhoneNumber);
                    break;
                case 4:
                    System.out.print("Enter passenger ID: ");
                    int passengerId = scanner.nextInt();
                    deletePassenger(passengerId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageAirports(Scanner scanner) {
        while (true) {
            System.out.println("Airports Menu:");
            System.out.println("1. List airports");
            System.out.println("2. Create airport");
            System.out.println("3. Update airport");
            System.out.println("4. Delete airport");
            System.out.println("5. Return to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listEntities("/airports");
                    break;
                case 2:
                    System.out.print("Enter airport name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter airport code: ");
                    String code = scanner.nextLine();
                    createAirport(name, code);
                    break;
                case 3:
                    System.out.print("Enter airport ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new airport name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new airport code: ");
                    String newCode = scanner.nextLine();
                    updateAirport(id, newName, newCode);
                    break;
                case 4:
                    System.out.print("Enter airport ID: ");
                    int airportId = scanner.nextInt();
                    deleteAirport(airportId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void manageAircraft(Scanner scanner) {
        while (true) {
            System.out.println("Aircraft Menu:");
            System.out.println("1. List aircraft");
            System.out.println("2. Create aircraft");
            System.out.println("3. Update aircraft");
            System.out.println("4. Delete aircraft");
            System.out.println("5. Return to main menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    listEntities("/aircrafts");
                    break;
                case 2:
                    System.out.print("Enter aircraft type: ");
                    String type = scanner.nextLine();
                    System.out.print("Enter airline name: ");
                    String airlineName = scanner.nextLine();
                    System.out.print("Enter number of passengers: ");
                    int numberOfPassengers = scanner.nextInt();
                    createAircraft(type, airlineName, numberOfPassengers);
                    break;
                case 3:
                    System.out.print("Enter aircraft ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new aircraft type: ");
                    String newType = scanner.nextLine();
                    System.out.print("Enter new airline name: ");
                    String newAirlineName = scanner.nextLine();
                    System.out.print("Enter new number of passengers: ");
                    int newNumberOfPassengers = scanner.nextInt();
                    updateAircraft(id, newType, newAirlineName, newNumberOfPassengers);
                    break;
                case 4:
                    System.out.print("Enter aircraft ID: ");
                    int aircraftId = scanner.nextInt();
                    deleteAircraft(aircraftId);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

//    private static void listEntities(String endpoint) {
//        try {
//            URL url = new URL(BASE_URL + endpoint);
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setRequestMethod("GET");
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
//                System.out.println("Entities: " + response.toString());
//            } else {
//                System.out.println("GET request failed");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    private static void listEntities(String endpoint) {
        HttpURLConnection conn = null;
        try {
            URL url = new URL(BASE_URL + endpoint);
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    System.out.println("Entities: " + response.toString());
                }
            } else {
                System.out.println("GET request failed with response code: " + responseCode);
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream()))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    System.out.println("Error response: " + response.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }


    private static void createCity(String name, String state, int population) {
        try {
            URL url = new URL(BASE_URL + "/cities");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String cityJson = String.format("{\"name\":\"%s\", \"state\":\"%s\", \"population\":%d}", name, state, population);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = cityJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Created city with ID: " + response.toString());
            } else {
                System.out.println("POST request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateCity(int id, String name, String state, int population) {
        try {
            URL url = new URL(BASE_URL + "/cities/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String cityJson = String.format("{\"id\":%d, \"name\":\"%s\", \"state\":\"%s\", \"population\":%d}", id, name, state, population);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = cityJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Updated city with ID: " + id);
            } else {
                System.out.println("PUT request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteCity(int id) {
        try {
            URL url = new URL(BASE_URL + "/cities/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Deleted city with ID: " + id);
            } else {
                System.out.println("DELETE request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createPassenger(String firstName, String lastName, String phoneNumber) {
        try {
            URL url = new URL(BASE_URL + "/passengers");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String passengerJson = String.format("{\"firstName\":\"%s\", \"lastName\":\"%s\", \"phoneNumber\":\"%s\"}", firstName, lastName, phoneNumber);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = passengerJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Created passenger with ID: " + response.toString());
            } else {
                System.out.println("POST request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updatePassenger(int id, String firstName, String lastName, String phoneNumber) {
        try {
            URL url = new URL(BASE_URL + "/passengers/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String passengerJson = String.format("{\"id\":%d, \"firstName\":\"%s\", \"lastName\":\"%s\", \"phoneNumber\":\"%s\"}", id, firstName, lastName, phoneNumber);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = passengerJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Updated passenger with ID: " + id);
            } else {
                System.out.println("PUT request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deletePassenger(int id) {
        try {
            URL url = new URL(BASE_URL + "/passengers/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Deleted passenger with ID: " + id);
            } else {
                System.out.println("DELETE request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createAirport(String name, String code) {
        try {
            URL url = new URL(BASE_URL + "/airports");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String airportJson = String.format("{\"name\":\"%s\", \"code\":\"%s\"}", name, code);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = airportJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Created airport with ID: " + response.toString());
            } else {
                System.out.println("POST request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateAirport(int id, String name, String code) {
        try {
            URL url = new URL(BASE_URL + "/airports/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String airportJson = String.format("{\"id\":%d, \"name\":\"%s\", \"code\":\"%s\"}", id, name, code);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = airportJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Updated airport with ID: " + id);
            } else {
                System.out.println("PUT request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteAirport(int id) {
        try {
            URL url = new URL(BASE_URL + "/airports/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Deleted airport with ID: " + id);
            } else {
                System.out.println("DELETE request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createAircraft(String type, String airlineName, int numberOfPassengers) {
        try {
            URL url = new URL(BASE_URL + "/aircraft");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String aircraftJson = String.format("{\"type\":\"%s\", \"airlineName\":\"%s\", \"numberOfPassengers\":%d}", type, airlineName, numberOfPassengers);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = aircraftJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                System.out.println("Created aircraft with ID: " + response.toString());
            } else {
                System.out.println("POST request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void updateAircraft(int id, String type, String airlineName, int numberOfPassengers) {
        try {
            URL url = new URL(BASE_URL + "/aircraft/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("PUT");
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            String aircraftJson = String.format("{\"id\":%d, \"type\":\"%s\", \"airlineName\":\"%s\", \"numberOfPassengers\":%d}", id, type, airlineName, numberOfPassengers);
            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = aircraftJson.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Updated aircraft with ID: " + id);
            } else {
                System.out.println("PUT request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deleteAircraft(int id) {
        try {
            URL url = new URL(BASE_URL + "/aircraft/" + id);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("DELETE");

            int responseCode = conn.getResponseCode();
            if (responseCode == 200) {
                System.out.println("Deleted aircraft with ID: " + id);
            } else {
                System.out.println("DELETE request failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
