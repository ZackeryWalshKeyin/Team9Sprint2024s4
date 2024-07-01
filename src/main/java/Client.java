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
                    System.out.print("Enter new province: ");
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
                    //createAirport(name, code);
                    break;
                case 3:
                    System.out.print("Enter airport ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new airport name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new airport code: ");
                    String newCode = scanner.nextLine();
                    //updateAirport(id, newName, newCode);
                    break;
                case 4:
                    System.out.print("Enter airport ID: ");
                    int airportId = scanner.nextInt();
                    //deleteAirport(airportId);
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

    private static void sendRequest(String endpoint, String method, String json) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(method);
            conn.setRequestProperty("Content-Type", "application/json; utf-8");
            conn.setDoOutput(true);

            if (json != null && !json.isEmpty()) {
                try (OutputStream os = conn.getOutputStream()) {
                    byte[] input = json.getBytes("utf-8");
                    os.write(input, 0, input.length);
                }
            }

            handleResponse(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleResponse(HttpURLConnection conn) {
        try {
            int responseCode = conn.getResponseCode();
            if (responseCode == 200 || responseCode == 201) { // 201 for successful POST
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();

                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }

                    System.out.println("Response: " + response.toString());
                }
            } else {
                System.out.println("Request failed with response code: " + responseCode);
                try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getErrorStream(), "utf-8"))) {
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

    private static void createCity(String city, String province, int population) {
        String cityJson = String.format("{\"city\":\"%s\", \"province\":\"%s\", \"population\":%d}", city, province, population);
        sendRequest("/cities", "POST", cityJson);
    }

    private static void updateCity(int id, String city, String province, int population) {
        String cityJson = String.format("{\"id\":%d, \"city\":\"%s\", \"province\":\"%s\", \"population\":%d}", id, city, province, population);
        sendRequest("/cities/" + id, "PUT", cityJson);
    }

    private static void deleteCity(int id) {
        sendRequest("/cities/" + id, "DELETE", null);
    }

    private static void listEntities(String endpoint) {
        sendRequest(endpoint, "GET", null);
    }

    private static void createAircraft(String type, String airlineName, int passengerCapacity) {
        String aircraftJson = String.format("{\"type\":\"%s\", \"airlineName\":\"%s\", \"passengerCapacity\":%d}", type, airlineName, passengerCapacity);
        sendRequest("/aircrafts", "POST", aircraftJson);
    }

    private static void updateAircraft(int id, String type, String airlineName, int passengerCapacity) {
        String aircraftJson = String.format("{\"id\":%d, \"type\":\"%s\", \"airlineName\":\"%s\", \"passengerCapacity\":%d}", id, type, airlineName, passengerCapacity);
        sendRequest("/aircrafts/" + id, "PUT", aircraftJson);
    }

    private static void deleteAircraft(int id) {
        sendRequest("/aircrafts/" + id, "DELETE", null);
    }

    private static void createPassenger(String name, String seatClass) {
        String passengerJson = String.format("{\"name\":\"%s\", \"seatClass\":\"%s\"}", name, seatClass);
        sendRequest("/passengers", "POST", passengerJson);
    }

    private static void updatePassenger(int id, String name, String seatClass) {
        String passengerJson = String.format("{\"id\":%d, \"name\":\"%s\", \"seatClass\":\"%s\"}", id, name, seatClass);
        sendRequest("/passengers/" + id, "PUT", passengerJson);
    }

    private static void deletePassenger(int id) {
        sendRequest("/passengers/" + id, "DELETE", null);
    }

}
