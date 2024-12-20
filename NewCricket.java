import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

/*
 * ------------------------------------- Player Detail
 * -------------------------------------------------------
 */
class Player {
    private final String name; // final keyword player's name cannot be changed
    private int runs;
    private int totalballplay;
    private int fours;
    private int sixes;

    // Class Constructor

    public Player(String name) {
        this.name = name;
        this.runs = 0;
        this.totalballplay = 0;
        this.fours = 0;
        this.sixes = 0;
    }

    public final void playBall(int result) throws InvalidInputException { // final method
        if (result < 0 || result > 6) {
            throw new InvalidInputException("Invalid runs! Runs must be between 0 and 6.");
        }
        totalballplay++; // Total Ball played
        runs += result;
        if (result == 4)
            fours++;
        else if (result == 6)
            sixes++;
    }

    public void displayStats() {
        System.out.println("Player Name : " + name);
        System.out.println("Runs Scored : " + runs);
        System.out.println("Balls Played : " + totalballplay);
        System.out.println("No. of 4's  : " + fours);
        System.out.println("No. of 6's  : " + sixes);
    }

    public String getName() {
        return name;
    }
}

/*
 * --------------------------------------Team -
 * 1-------------------------------------------------------
 */

class Team1 {
    private Player[] players;
    private int currentBatting;
    private int totalScore;
    private int wicketsLost;
    private int ballsBowled;
    private int extras;
    private int wideBalls;
    private int noBalls;

    // Static variable
    private static int teamCount = 0;

    // Constructor
    public Team1(String[] playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
        currentBatting = 0;
        totalScore = 0;
        wicketsLost = 0;
        ballsBowled = 0;
        extras = 0;
        wideBalls = 0;
        noBalls = 0;

        teamCount++; // Increment the team count whenever a new team is created
    }

    public void playBall(int result) throws InvalidInputException {
        Scanner sc = new Scanner(System.in);
        switch (result) {
            case 1: /* ==========Wicket============ */
                System.out.println(players[currentBatting].getName() + " got out!");
                wicketsLost++;
                ballsBowled++;
                currentBatting++;
                break;
            case 2: /* ==========Normal Run============ */
                System.out.print("Enter Runs Scored (0-6): ");
                int runs = sc.nextInt();
                players[currentBatting].playBall(runs);
                totalScore += runs;
                ballsBowled++;
                System.out.println(runs + " Runs Scored.");
                break;
            case 3: /* ==========Wide Ball============ */
                wideBalls++;
                extras++;
                totalScore++;
                System.out.println("Wide ball! 1 extra run.");
                System.out.print("Enter additional runs scored off the wide (0-6): ");
                int wideRuns = sc.nextInt();
                if (wideRuns > 0) {
                    totalScore += wideRuns;
                    System.out.println(wideRuns + " additional runs scored off the wide ball.");
                }
                break;
            case 4: /* ==========No Ball============ */
                noBalls++;
                extras++;
                totalScore++;
                System.out.println("No ball! 1 extra run. Free hit awarded.");
                System.out.print("Enter runs scored off the no ball (0-6): ");
                int noBallRuns = sc.nextInt();
                if (noBallRuns > 0) {
                    players[currentBatting].playBall(noBallRuns);
                    totalScore += noBallRuns;
                    System.out.println(noBallRuns + " runs scored off the no ball.");
                }
                break;
            default:
                throw new InvalidInputException("Invalid choice! Please enter 1, 2, 3, or 4.");
        }
    }

    public void displayTeamStats() {
        System.out.println("Team Score: " + totalScore + "/" + wicketsLost);
        System.out.println("Extras: " + extras + " (Wide: " + wideBalls + ", No Ball: " + noBalls + ")");
        System.out.println("Total Balls Bowled: " + ballsBowled);
        System.out.println("\nPlayer Stats:");
        for (int i = 0; i <= currentBatting && i < players.length; i++) {
            players[i].displayStats();
            System.out.println();
        }
    }

    // Static method to get the total number of teams created
    public static int getTeamCount() {
        return teamCount;
    }

    public int getWicketsLost() {
        return wicketsLost;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }
}

/*
 * --------------------------------------Team -
 * 2-------------------------------------------------------
 */

class Team2 {
    private Player[] players;
    private int currentBatting;
    private int totalScore;
    private int wicketsLost;
    private int ballsBowled;
    private int extras;
    private int wideBalls;
    private int noBalls;

    // Static variable
    private static int teamCount = 0;

    // Constructor
    public Team2(String[] playerNames) {
        players = new Player[playerNames.length];
        for (int i = 0; i < playerNames.length; i++) {
            players[i] = new Player(playerNames[i]);
        }
        currentBatting = 0;
        totalScore = 0;
        wicketsLost = 0;
        ballsBowled = 0;
        extras = 0;
        wideBalls = 0;
        noBalls = 0;

        teamCount++; // Increment the team count whenever a new team is created
    }

    public void playBall(int result) throws InvalidInputException {
        Scanner sc = new Scanner(System.in);
        switch (result) {
            case 1: /* ==========Wicket============ */
                System.out.println(players[currentBatting].getName() + " got out!");
                wicketsLost++;
                ballsBowled++;
                currentBatting++;
                break;
            case 2: /* ==========Normal Run============ */
                System.out.print("Enter Runs Scored (0-6): ");
                int runs = sc.nextInt();
                players[currentBatting].playBall(runs);
                totalScore += runs;
                ballsBowled++;
                System.out.println(runs + " Runs Scored.");
                break;
            case 3: /* ==========Wide Ball============ */
                wideBalls++;
                extras++;
                totalScore++;
                System.out.println("Wide ball! 1 extra run.");
                System.out.print("Enter additional runs scored off the wide (0-6): ");
                int wideRuns = sc.nextInt();
                if (wideRuns > 0) {
                    totalScore += wideRuns;
                    System.out.println(wideRuns + " additional runs scored off the wide ball.");
                }
                break;
            case 4: /* ==========No Ball============ */
                noBalls++;
                extras++;
                totalScore++;
                System.out.println("No ball! 1 extra run. Free hit awarded.");
                System.out.print("Enter runs scored off the no ball (0-6): ");
                int noBallRuns = sc.nextInt();
                if (noBallRuns > 0) {
                    players[currentBatting].playBall(noBallRuns);
                    totalScore += noBallRuns;
                    System.out.println(noBallRuns + " runs scored off the no ball.");
                }
                break;
            default:
                throw new InvalidInputException("Invalid choice! Please enter 1, 2, 3, or 4.");
        }
    }

    public void displayTeamStats() {
        System.out.println("Team Score: " + totalScore + "/" + wicketsLost);
        System.out.println("Extras: " + extras + " (Wide: " + wideBalls + ", No Ball: " + noBalls + ")");
        System.out.println("Total Balls Bowled: " + ballsBowled);
        System.out.println("\nPlayer Stats:");
        for (int i = 0; i <= currentBatting && i < players.length; i++) {
            players[i].displayStats();
            System.out.println();
        }
    }

    // Static method to get the total number of teams created
    public static int getTeamCount() {
        return teamCount;
    }

    public int getWicketsLost() {
        return wicketsLost;
    }

    public int getBallsBowled() {
        return ballsBowled;
    }
}

/*--------------------------------Main Class----------------------------------------------------*/

public final class NewCricket { // final class
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            final String[] playerNames = { // final array of player names,
                    "Virat Kohli", "Rohit Sharma", "Shubman Gill", "Ravindra Jadeja", "KL Rahul",
                    "Suryakumar Yadav", "Shreyas Iyer", "Mohammad Siraj", "Ishan Kishan", "Kuldeep Yadav", "MS Dhoni"
            };
            final String[] playerNames2 = { "Pat Cumins", "Steve Smith", "David Warmar", "Travis Head", "Glenn Maxwell",
                    "Mitchell Strac", "Camaron Green", "Marcus Zampa", "Sean Abbott", "Alex Carey", "Josh Inglis" };

            System.out.print("Enter number of overs: ");
            int overs = sc.nextInt();
            int totalBalls = overs * 6;

            System.out.println("\n<===============Play Match Team 1==============>\n");

            Team1 team1 = new Team1(playerNames); // Object Team 1
            while (team1.getBallsBowled() < totalBalls && team1.getWicketsLost() < 10) {
                System.out.println(
                        "\nBall " + (team1.getBallsBowled() + 1) + " of over " + ((team1.getBallsBowled() / 6) + 1));
                System.out.println("1. Wicket");
                System.out.println("2. Run");
                System.out.println("3. Wide Ball");
                System.out.println("4. No Ball");
                System.out.print("Enter your choice: ");
                int result = sc.nextInt();
                team1.playBall(result);

            }

            System.out.println("\n<===============Play Match Team 2==============>\n");

            Team2 team2 = new Team2(playerNames2); // Object Team 2
            while (team2.getBallsBowled() < totalBalls && team2.getWicketsLost() < 10) {
                System.out.println(
                        "\nBall " + (team2.getBallsBowled() + 1) + " of over " + ((team2.getBallsBowled() / 6) + 1));
                System.out.println("1. Wicket");
                System.out.println("2. Run");
                System.out.println("3. Wide Ball");
                System.out.println("4. No Ball");
                System.out.print("Enter your choice: ");
                int result = sc.nextInt();
                team2.playBall(result);

            }

            System.out.println("\n<--------------Final---Team 1 Score------------->\n");
            team1.displayTeamStats();
            System.out.println("\n<--------------Final---Team 2 Score------------->\n");
            team2.displayTeamStats();

        

        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please try again.");
            e.printStackTrace();
        } finally {
            sc.close(); // Scanner Close
        }
    }
}
