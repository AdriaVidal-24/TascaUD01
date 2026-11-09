# Gestió de Lloguer de Videojocs

Aplicació d'escriptori feta amb Java Swing i NetBeans per gestionar usuaris, videojocs i lloguers. Les dades es guarden en memòria durant l'execució.

## Execució

1. Obre el projecte `TascaUD01` amb NetBeans (projecte Maven, JDK 25).
2. Executa'l amb **Run Project** (F6). La classe principal és `cat.paucasesnoves.lloguerjocs.interficie.FinestraPrincipal`.

## Estructura

- `dto`: classes de dades (`Usuari`, `Joc`, `Lloguer`, `Plataforma`, `Genere`, `EstatLloguer`).
- `logica`: `LogicaNegoci`, amb les llistes en memòria i les regles de negoci.
- `interficie`: finestra principal i diàlegs, i `models` amb els models de les taules.
- `org.netbeans.validation.api.builtin.stringvalidation`: validadors propis que amplien la ValidationAPI (`ValidacioMajuscula`, `ValidacioDni`, `ValidacioTelefon`) i el fitxer `Bundle_ca` amb els missatges en català.

## Funcionalitats

- **Lloguer → Registrar...**: registra un lloguer. Les dates s'assignen soles (7 dies) i només es poden triar les plataformes amb unitats disponibles. Si hi ha una fila seleccionada, el formulari s'obre amb el seu usuari i joc.
- **Lloguer → Tornar...**: marca un lloguer com a retornat i torna la unitat a l'estoc.
- **Usuari / Joc → Crear... / Esborrar...**: alta i baixa d'usuaris i jocs. No es poden esborrar si tenen lloguers actius.
- **Idioma**: canvia la interfície entre català, castellà i anglès.
- A la taula principal, els lloguers fora de termini surten en vermell i els retornats en verd.

## Dades inicials

| Usuari | DNI | Telèfon |
|---|---|---|
| Marta Ferrer Pons | 43123456C | 612345678 |
| Joan Riera Bauzà | 41234567Y | 971234567 |
| Aina Capó Vidal | 78901234X | 678901234 |

| Joc | Gènere | Unitats |
|---|---|---|
| EA Sports FC 25 | Esports | PS5: 2 · Switch 2: 1 |
| Forza Horizon 5 | Curses | Xbox: 1 · PC: 2 |
| Minecraft | Aventura | PS5: 1 · Switch 2: 1 · Xbox: 1 · PC: 1 |

| Núm. | Usuari | Joc | Plataforma | Estat |
|---|---|---|---|---|
| 01 | Aina Capó | Minecraft | PC | Retornat (verd) |
| 02 | Marta Ferrer | Forza Horizon 5 | Xbox | Fora de termini (vermell) |
| 03 | Joan Riera | EA Sports FC 25 | Switch 2 | Actiu |

Casos per provar: Forza Horizon 5 a Xbox i EA Sports FC 25 a Switch 2 no tenen estoc, i Marta Ferrer i Joan Riera no es poden esborrar perquè tenen lloguers actius.
