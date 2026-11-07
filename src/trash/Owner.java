package trash;

public class Owner {
//        private String name;
//        private List<Item> items;
//
//        // 1. Главный конструктор — всё через add
//        public trash.Owner(String name, List<Item> items) {
//            this.name = name;
//            this.items = new ArrayList<>();
//            for (Item i : items) addItem(i);
//        }
//
//        // 2. Остальные — через this(...)
//        public trash.Owner(String name, Item... items) { this(name, Arrays.asList(items)); }
//        public trash.Owner(String name)                { this(name, new ArrayList<>()); }
//        public trash.Owner(trash.Owner o)                    { this(o.name, o.getItems()); }
//
//        // 3. Геттер — копия
//        public List<Item> getItems() { return new ArrayList<>(items); }
//
//        // 4. add — все проверки тут
//        public void addItem(Item i) {
//            if (i == null) throw new RuntimeException();
//            if (!items.contains(i)) items.add(i);
//        }
//
//        // 5. remove — просто удалить
//        public void removeItem(Item i) { items.remove(i); }
//
//        // 6. set — сначала проверить, потом менять
//        public void setItems(List<Item> newItems) {
//            for (Item i : newItems) if (i == null) throw new RuntimeException();
//            items = new ArrayList<>();
//            for (Item i : newItems) addItem(i);
//        }
//
//        // 7. Правило из условия — своё исключение
//        public void setText(String text) {
//            if (!items.isEmpty()) throw new MyException();
//            // ...
//        }
//
//        @Override
//        public String toString() { return name + " " + items; }

        /*
         * ЧЕК-ЛИСТ ПЕРЕД СДАЧЕЙ
         *
         * [ ] Поля private, список создаётся в конструкторе (new ArrayList<>())
         * [ ] Геттер списка возвращает копию: return new ArrayList<>(items)
         * [ ] add(null) -> исключение
         * [ ] В if проверяю ПАРАМЕТР, а не поле (не comments != null, а comment != null)
         * [ ] В условии ==, а не = (st.isFinished = false — ошибка!)
         * [ ] Откат в set: копия из ТЕКУЩЕГО списка — new ArrayList<>(this.items)
         *     (или лучше: сначала проверить всё, потом менять)
         * [ ] Правило из условия -> СВОЁ исключение, а не RuntimeException
         * [ ] toString не зацикливается (у связанных объектов — только имена)
         * [ ] Двусторонняя связь: contains + сначала add к себе, потом другой стороне
         * [ ] В trash.Main проверены все правила, исключения — через try/catch
         */

        // односторонняя
//        public void addComment(trash.Comment c) {
//            if (c == null) throw new RuntimeException();
//            comments.add(c);
//        }
//
//        // двусторонняя
//        public void addAuthor(trash.Author a) {
//            if (a == null) throw new RuntimeException();
//            if (!authors.contains(a)) {
//                authors.add(a);
//                a.addBook(this);   // ← вот вся разница
//            }
//        }

        //второй член двусторонней связи
//        public void addAuthor(trash.Author author) {
//            if (author != null) {
//                if (!this.authors.contains(author)) {
//                    this.authors.add(author);
//                    author.addBook(this);
//                }
//            }
//        }

        /*         *
         * --- List / ArrayList ---
         * list.add(x);  list.add(i, x);        // в конец / по индексу
         * list.get(i);  list.set(i, x);        // взять / заменить
         * list.remove(i);  list.remove(x);     // по индексу / по объекту
         * list.contains(x);  list.indexOf(x);  // есть ли / где (-1 если нет)
         * list.lastIndexOf(x);                 // последнее вхождение
         * list.size();  list.isEmpty();  list.clear();
         * list.addAll(other);                  // добавить все из other
         * list.removeAll(other);               // убрать все, что есть в other
         * list.retainAll(other);               // оставить только общие
         * list.containsAll(other);             // все ли из other есть
         * list.subList(from, to);              // кусок [from, to)
         * list.removeIf(x -> условие);         // удалить по условию
         * list.forEach(x -> System.out.println(x));
         * list.sort(null);                     // сортировка по возрастанию
         * list.toArray(new trash.Task[0]);           // список -> массив
         * list.equals(other);                  // равны ли поэлементно
         *
         * --- Создание списков ---
         * new ArrayList<>();                   // пустой
         * new ArrayList<>(other);              // копия
         * List.of(a, b, c);                    // неизменяемый, без null
         * Arrays.asList(arr);                  // из массива, размер фиксирован
         * Collections.emptyList();             // пустой неизменяемый
         * Collections.nCopies(3, "x");         // [x, x, x]
         *
         * --- Collections ---
         * Collections.sort(list);  Collections.reverse(list);
         * Collections.max(list);   Collections.min(list);
         * Collections.shuffle(list);           // перемешать
         * Collections.swap(list, i, j);        // поменять местами
         * Collections.frequency(list, x);      // сколько раз встречается x
         * Collections.addAll(list, a, b, c);   // добавить много (варарг/массив)
         * Collections.unmodifiableList(list);  // обёртка "только чтение"
         *
         * --- Arrays ---
         * Arrays.toString(arr);  Arrays.deepToString(matrix);  // вывод
         * Arrays.sort(arr);  Arrays.fill(arr, 0);
         * Arrays.copyOf(arr, n);  Arrays.copyOfRange(arr, a, b);
         * Arrays.equals(a, b);  Arrays.asList(arr);
         * Arrays.binarySearch(arr, x);         // поиск в отсортированном
         *
         * --- String ---
         * s.length();  s.isEmpty();  s.isBlank();     // пусто / только пробелы
         * s.charAt(i);  s.indexOf("ab");  s.contains("ab");
         * s.substring(a, b);  s.substring(a);
         * s.equals(t);  s.equalsIgnoreCase(t);  s.compareTo(t);
         * s.startsWith("a");  s.endsWith("z");
         * s.toUpperCase();  s.toLowerCase();
         * s.trim();  s.strip();                       // убрать пробелы по краям
         * s.replace("a", "b");  s.split(",");
         * s.repeat(3);                                // "ab" -> "ababab"
         * String.join(", ", list);                    // склеить через разделитель
         * String.valueOf(5);                          // число -> строка
         * s.toCharArray();                            // строка -> char[]
         *
         * --- StringBuilder (сборка строки в цикле) ---
         * StringBuilder sb = new StringBuilder();
         * sb.append("x").append(5);  sb.insert(0, "start");
         * sb.reverse();  sb.deleteCharAt(sb.length() - 1);
         * sb.toString();
         *
         * --- Числа ---
         * Integer.parseInt("42");  Double.parseDouble("3.5");
         * Integer.MAX_VALUE;  Integer.MIN_VALUE;
         * Math.max(a, b);  Math.min(a, b);  Math.abs(x);
         * Math.pow(a, b);  Math.sqrt(x);  Math.round(x);
         * Math.random();                              // [0, 1)
         *
         * --- Objects ---
         * Objects.equals(a, b);                // сравнить, не боясь null
         * Objects.requireNonNull(x);           // NPE, если x == null
         * Objects.isNull(x);  Objects.nonNull(x);
         *
         * --- Варарг -> список без asList ---
         * List<T> list = new ArrayList<>();
         * for (T x : arr) addX(x);             // с проверками через add
         * Collections.addAll(list, arr);       // коротко, но null не проверяется
         *
         * --- САМОЕ ПОЛЕЗНОЕ НА ЗАЧЁТЕ ---
         * String.join(", ", names)       -> toString без цикла с запятыми
         * removeIf(t -> t.isFinished())  -> удаление по условию
         * Collections.frequency(...)     -> подсчёт
         * Objects.equals(a, b)           -> сравнение без NPE
         */
    }