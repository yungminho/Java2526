## Opis zadania

Celem zadania jest napisanie dwóch klas reprezentujących:

- **𝑛-wymiarowy wektor**
- **𝑛×𝑛 macierz**

Wymiar **𝑛** powinien być przekazywany jako argument konstruktora.

### Wymagania funkcjonalne

Należy zaimplementować metody odpowiedzialne za:

1. **Dodawanie**
   - Wektor + Wektor
   - Macierz + Macierz

2. **Iloczyn skalarny**
   - Dla wektorów:  
    $` \sum_{i=1}^{n} a_i b_i `$
   - Dla macierzy:  
    $` \sum_{i=1}^{n} \sum_{j=1}^{n} a_{ij} b_{ij} `$

3. **Iloczyn macierzy**
   $` c_{ij} = \sum_{k=1}^{n} a_{ik} b_{kj} `$

4. **Iloczyn tensorowy wektorów**
   $` c_{ij} = a_i b_j `$
   Wynikiem jest macierz.

5. **Mnożenie przez skalar**
   - Dla wektora: $`  a_i \times k  `$
   - Dla macierzy: $`  a_{ij} \times k  `$

Dodatkowo należy **wykorzystać dziedziczenie** w implementacji.

---

## Struktura projektu
```
zadaniaDomowe/
└── zad2/
    ├── Addable.java
    ├── Scalable.java
    ├── DotProduct.java
    ├── Multipliable.java
    ├── Tensor.java
    ├── Vector.java
    ├── Matrix.java
    └── Main.java
```

```
            +---------------------+            +---------------------+            +---------------------+
            |     Addable<T>      |            |     Scalable<T>     |            |    DotProduct<T>    |
            +---------------------+            +---------------------+            +---------------------+
                                                        ▲
                                                        |
                            +----------------------------------------------------------------+
                            |                     Tensor (abstract)                          |
                            |          implements: Addable, Scalable, DotProduct             |
                            +----------------------------------------------------------------+
                                ▲                                                     ▲
                                |                                                     |
                      +---------------------+                              +-----------------------+
                      |       Vector        |                              |       Matrix          |          +----------------------------+
                      |  extends Tensor     |                              |  extends Tensor       |    - ►   |    Multipliable<Matrix>    |
                      |  + tensor(Vector)   |                              |  implements           |          +----------------------------+
                      +---------------------+                              |  Multipliable<Matrix> |
                                                                           +-----------------------+


```

