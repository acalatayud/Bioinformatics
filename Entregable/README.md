
# Bioinformatica 2019 Heimann, Calatayud

## Pasos para ejecutar los ejercicios.

1. Ejercicio 1: Procesamiento de secuencias de nucleotidos a secuencias de aminoacidos

```sh
$ ./ex1.sh <archivo_input>
```

donde
* archivo_input es el archivo de la secuencia (un archivo de ejemplo se encuentra en *./examples/sequence_example.gb*)

2. Ejercicio 2: BLAST de secuencias

```sh
$ ./ex2.sh <archivo_input>
```

donde
* archivo_input es el archivo de secuencias a ejecutar BLAST (un archivo de ejemplo se encuentra en *./examples/frame_examples.fas*)

3. Ejercicio 4: Analisis de archivo BLAST

```sh
$ ./ex4.sh <archivo_input> <pattern>
```

donde
* archivo_input es el archivo BLAST (un archivo de ejemplo se encuentra en *./examples/blast_example.out*)
* pattern es el patron que se busca dentro de los resultados (un ejemplo es *homo sapiens*)


4. Ejercicio 5a: Calculo de ORF de una secuencia de nucleotidos

```sh
$ ./ex5_a.sh <archivo_input>
```

donde
* archivo_input es el archivo de secuencias (un archivo de ejemplo se encuentra en *./examples/sequence_example.gb*)


5. Ejercicio 5b: Analisis de dominios de secuencias de aminoacidos
   
```sh
$ ./ex5_b.sh <archivo_input>
```
   
donde
* archivo_input es el archivo de secuencias (un archivo de ejemplo se encuentra en *./examples/emboss_sequence_example.fas*)