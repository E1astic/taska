import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        LocalTime start=LocalTime.parse(s);
        int n=scan.nextInt();
        scan.nextLine();

        String[] team=new String[n];
        LocalTime[] time=new LocalTime[n];
        String[] server=new String[n];
        String[] result=new String[n];

        Map<String,Integer>countSolutions=new HashMap<>();
        Map<String,Integer>finalTime=new HashMap<>();

        // ключ - имя команды, значение - собственная мапа для каждой команды с ключами-серверами и значениями-числом попыток
        Map<String, Map<String, Integer>> informationOfEveryTeam =new HashMap<>();

        for(int i=0;i<n;++i)
        {
            String str=scan.nextLine();
            String[]arg=str.split(" ");

            team[i]=arg[0];
            time[i]=LocalTime.parse(arg[1]);
            server[i]=arg[2];
            result[i]=arg[3];

            Map<String, Integer> countAttemptsEveryServers = informationOfEveryTeam.computeIfAbsent(team[i], k -> new HashMap<>());

            if (result[i].equals("FORBIDDEN") || result[i].equals("DENIED"))
            {
                countAttemptsEveryServers.put(server[i], countAttemptsEveryServers.getOrDefault(server[i], 0) + 1);
            }
            else
            {
                int clearTimeSolution = (time[i].toSecondOfDay() - start.toSecondOfDay())/60;
                int penaltyTimeSolution = 20 * informationOfEveryTeam.get(team[i]).getOrDefault(server[i], 0);
                finalTime.put(team[i], finalTime.getOrDefault(team[i], 0) + clearTimeSolution + penaltyTimeSolution);
                countSolutions.put(team[i], countSolutions.getOrDefault(team[i], 0) + 1);
            }
        }

        List<Result> res=new ArrayList<>();

        for(String teams: informationOfEveryTeam.keySet())
        {
            res.add(new Result(teams, countSolutions.get(teams), finalTime.get(teams)));
        }

        Comparator<Result> solutionsAndTimeComparator=new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2)
            {
                if(o1.solutions<o2.solutions)
                    return 1;
                if(o1.solutions>o2.solutions)
                    return -1;

                if(o1.minutes<o2.minutes)
                    return -1;
                if(o1.minutes>o2.minutes)
                    return 1;

                return o1.name.compareTo(o2.name);
            }
        };
        res.sort(solutionsAndTimeComparator);

        for(int i=0;i<res.size();++i)
        {
            System.out.println(i+1 +" " + res.get(i).toString());
        }

    }
}