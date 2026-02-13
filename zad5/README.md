## Opis zadania

Celem zadania jest implementacja strumieni filtrujących (decorator pattern), które realizują **Szyfr Cezara** do kodowania i dekodowania danych tekstowych.
### Wymagania funkcjonalne

Należy zaimplementować mechanizm przesunięcia (shift) dla liter alfabetu łacińskiego (A-Z, a-z), pomijając znaki specjalne, cyfry i białe znaki. Główne komponenty to:

1. Szyfrowanie (CezarOutputStream)

- Klasa rozszerzająca FilterOutputStream.

- Przesunięcie znaku o wartość $n$ w prawo wewnątrz alfabetu.

- Wzór dla dużych liter: $ (c - A + shift)\ (mod \ 26) + A$

2. Deszyfrowanie (CezarInputStream)

- Klasa rozszerzająca FilterInputStream.

- Przesunięcie znaku o wartość $n$ w lewo (odwrócenie szyfru).

- Wzór dla dużych liter: $ (c - A - shift + 26)\ (mod \ 26) + A$

3. Demonstracja działania

- Odczyt tekstu jawnego z pliku `plain.txt`.

- Zapis zaszyfrowanej treści do pliku `encrypted.txt`.

- Ponowny odczyt zaszyfrowanego pliku i zapis zdekodowanej treści do `decrypted.txt`.
---

## Struktura projektu
```
zadaniaDomowe/
└── zad5/
    ├── CezarInputStream.java
    ├── CezarOutputStream.java
    ├── StreamDemo.java
    ├── plain.txt
    ├── encrypted.txt
    └── decrypted.txt
```

```
            +---------------------+             +----------------------+
            |     InputStream     |             |     OutputStream     |
            +---------------------+             +----------------------+
                       ▲                                   ▲
                       |                                   |
            +---------------------+             +----------------------+
            |  FilterInputStream  |             |  FilterOutputStream  |
            +---------------------+             +----------------------+
                       ▲                                   ▲
                       |                                   |
            +---------------------+             +----------------------+
            |   CezarInputStream  |             |   CezarOutputStream  |
            +---------------------+             +----------------------+
            |  + read(): int      |             |  + write(int): void  |
            |  - decode(char): int|             |  - encode(char): int |
            +---------------------+             +----------------------+


```

