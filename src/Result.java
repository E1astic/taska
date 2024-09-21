import java.time.LocalTime;

public class Result {
    public String name;
    public int solutions;
    public int minutes;

    public Result(String name, int solutions, int minutes) {
        this.name = name;
        this.solutions = solutions;
        this.minutes = minutes;
    }

    public String toString()
    {
        return name+" "+solutions+" "+minutes;
    }
}
