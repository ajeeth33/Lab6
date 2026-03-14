public class MazeSolver {

    private char[][] maze;

    public MazeSolver(char[][] maze) {
        this.maze = maze;
    }

    public void printMaze() {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("--------------------");
    }

    public boolean solve() {
        int startRow = -1;
        int startCol = -1;

        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    break;
                }
            }
        }

        if (startRow != -1) {
            return solve(startRow, startCol);
        }
        return false;
    }

    private boolean solve(int row, int col) {
        if (row < 0 || row >= maze.length || col < 0 || col >= maze[0].length) {
            return false;
        }

        if (maze[row][col] == '#' || maze[row][col] == '.') {
            return false;
        }

        if (maze[row][col] == 'F') {
            return true;
        }

        if (maze[row][col] != 'S') {
            maze[row][col] = '.';
        }

        if (solve(row - 1, col)) return true; // North
        if (solve(row, col + 1)) return true; // East
        if (solve(row + 1, col)) return true; // South
        if (solve(row, col - 1)) return true; // West

        if (maze[row][col] != 'S') {
            maze[row][col] = ' ';
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] solvableMaze = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', ' ', '#'},
            {'#', ' ', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', ' ', ' ', ' ', '#'},
            {'#', ' ', ' ', ' ', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        char[][] unsolvableMaze = {
            {'#', '#', '#', '#', '#', '#', '#'},
            {'#', 'S', ' ', '#', ' ', '#', '#'},
            {'#', '#', ' ', '#', ' ', '#', '#'},
            {'#', ' ', '#', '#', ' ', '#', '#'},
            {'#', ' ', ' ', '#', '#', 'F', '#'},
            {'#', '#', '#', '#', '#', '#', '#'}
        };

        MazeSolver solver1 = new MazeSolver(solvableMaze);
        System.out.println("Solvable Maze - Original:");
        solver1.printMaze();

        if (solver1.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver1.printMaze();

        MazeSolver solver2 = new MazeSolver(unsolvableMaze);
        System.out.println("Unsolvable Maze - Original:");
        solver2.printMaze();

        if (solver2.solve()) {
            System.out.println("Solution Found:");
        } else {
            System.out.println("No Solution Found:");
        }
        solver2.printMaze();
    }
}
