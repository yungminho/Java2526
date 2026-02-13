import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CompletableFuture;


public class SprawdzianDrugi {
    public static void main(String[] args) {

        CompletableFuture<HashSet<String>> szalenstwaSetFuture = CompletableFuture.supplyAsync(() -> {
            try { return slowaWTekscie("makuszynski-szalenstwa-panny-ewy.txt"); } catch (IOException e) { throw new  RuntimeException(e); }
        });

        CompletableFuture<HashSet<String>> pannaSetFuture = CompletableFuture.supplyAsync(() -> {
            try { return slowaWTekscie("makuszynski-panna-z-mokra-glowa.txt"); } catch (IOException e) { throw new  RuntimeException(e); }
        });

        CompletableFuture<HashSet<String>> wampirSetFuture = CompletableFuture.supplyAsync(() -> {
            try { return slowaWTekscie("reymont-wampir.txt"); } catch (IOException e) { throw new  RuntimeException(e); }
        });

        CompletableFuture<HashMap<Integer,Integer>> szalenstwaMapFuture = CompletableFuture.supplyAsync(() -> {
            try { return obliczanieRozkladu("makuszynski-szalenstwa-panny-ewy.txt"); } catch (IOException e) { throw new  RuntimeException(e); }
        });

        CompletableFuture<HashMap<Integer,Integer>> pannaMapFuture = CompletableFuture.supplyAsync(() -> {
            try { return obliczanieRozkladu("makuszynski-panna-z-mokra-glowa.txt"); } catch (IOException e) { throw new  RuntimeException(e); }
        });

        CompletableFuture<HashMap<Integer,Integer>> wampirMapFuture = CompletableFuture.supplyAsync(() -> {
            try { return obliczanieRozkladu("reymont-wampir.txt"); } catch (IOException e) { throw new  RuntimeException(e); }
        });


        try (BufferedWriter rozwiazanie1 = new BufferedWriter(new FileWriter("szalenstwa-wampir-lista.txt"));
             BufferedWriter rozwiazanie2 = new BufferedWriter(new FileWriter("szalenstwa-panna-lista.txt"));
             BufferedWriter rozwiazanie3 = new BufferedWriter(new FileWriter("szalenstwa-rozklad.txt"));
             BufferedWriter rozwiazanie4 = new BufferedWriter(new FileWriter("wampir-rozklad.txt"));
             BufferedWriter rozwiazanie5 = new BufferedWriter(new FileWriter("panna-rozklad.txt"))
        ) {

            HashSet<String> szalenstwaSet = szalenstwaSetFuture.join();
            HashSet<String> pannaSet = pannaSetFuture.join();
            HashSet<String> wampirSet = wampirSetFuture.join();

            HashMap<Integer, Integer> szalenstwaMap = szalenstwaMapFuture.join();
            HashMap<Integer, Integer> pannaMap = pannaMapFuture.join();
            HashMap<Integer, Integer> wampirMap = wampirMapFuture.join();

            for (String word : szalenstwaSet) {
                if (!wampirSet.contains(word)) {
                    rozwiazanie1.write(word);
                    rozwiazanie1.newLine();
                }
            }

            for (String word : szalenstwaSet) {
                if (!pannaSet.contains(word)) {
                    rozwiazanie2.write(word);
                    rozwiazanie2.newLine();
                }
            }

            rozkladProcentowy(szalenstwaMap, rozwiazanie3);
            rozkladProcentowy(pannaMap, rozwiazanie4);
            rozkladProcentowy(wampirMap, rozwiazanie5);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static HashSet<String> slowaWTekscie(String source) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(source)));
        String line;
        HashSet<String> wynik = new HashSet<>();

        while ((line = br.readLine()) != null) {
            String cleaned = line.replaceAll("[^\\p{L}\\s]", "").toLowerCase();
            for (String word : cleaned.split("\\s+")) {
                if (!word.isEmpty()) {
                    wynik.add(word);
                }
            }
        }
        return wynik;
    }

    private static HashMap<Integer, Integer> obliczanieRozkladu(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));

        StringBuilder fulltext = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            fulltext.append(line).append(" ");
        }

        br.close();

        HashMap<Integer, Integer> rozklad = new HashMap<>();

        String[] zdania = fulltext.toString().split("(?<=[.!?])\\s+");

        for (String zdanie : zdania) {
            String cleaned = zdanie.replaceAll("[^\\p{L} ]", "").toLowerCase().trim();

            if (cleaned.isEmpty()) continue;

            int length = cleaned.split("\\s+").length;

            rozklad.put(length, rozklad.getOrDefault(length, 0) + 1);
        }

        return rozklad;
    }

    private static void rozkladProcentowy(HashMap<Integer, Integer> rozklad, BufferedWriter out) throws IOException {
        int total = rozklad.values().stream().mapToInt(i -> i).sum();

        var sorted = rozklad.entrySet().stream().sorted(Map.Entry.comparingByKey()).toList();

        for (var e : sorted) {
            int length = e.getKey();
            int count = e.getValue();

            int percent = (int) Math.round((count * 100.0) / total);

            out.write(length + " słowa - " + percent + "%");
            out.newLine();
        }

    }
}