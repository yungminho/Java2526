# Obliczanie pierwiastka B-tego stopnia z liczby A

## Opis zadania
Należy napisać program, który przyjmuje dwa argumenty:
- **A** – liczba, z której obliczany będzie pierwiastek,  
- **B** – stopień pierwiastka.  

Program powinien obliczyć **pierwiastek B-tego stopnia z liczby A** bez korzystania z gotowych metod matematycznych (np. `Math.pow()`, `Math.sqrt()`, itp.).

## Wymagania
- Program **nie może korzystać** z metod wbudowanych klasy `Math` ani innych bibliotek realizujących pierwiastkowanie.  
- Należy zaimplementować własny algorytm obliczania pierwiastka, np. metodą:
  - **bisekcji (binary search)**,  
  - **Newtona-Raphsona**,  
  - lub inną numeryczną metodą przybliżoną.  

## Dane wejściowe
Program przyjmuje dwa argumenty z linii poleceń lub wejścia standardowego:


### Przykład
**Wejście:**
27 3
**Wynik:**
3


## Sposób uruchomienia
```bash
javac Main.java
java Main 27 3

```

## Opis Metod
- calculateRoot(double a, double root) – oblicza pierwiastek B-tego stopnia z liczby A, obsługuje liczby ujemne i ułamkowe wykładniki.
- nthRoot(double number, double root) – implementacja metody Newtona-Raphsona, iteracyjnie przybliżająca wynik.
- pow(double base, double exp) – własna implementacja potęgowania z wykorzystaniem wzoru a^b = e^(b * ln(a)).
- lnApprox(double x) – przybliżenie logarytmu naturalnego metodą Newtona.
- expApprox(double x) – przybliżenie funkcji wykładniczej z wykorzystaniem szeregu Taylora.
- abs(double x) – zwraca wartość bezwzględną.
- floor(double x) – zwraca największą liczbę całkowitą mniejszą lub równą x.

## Stałe
- EPSILON = 1e-12 — dokładność obliczeń.
- MAX_ITERATIONS = 10_000 — maksymalna liczba iteracji.
