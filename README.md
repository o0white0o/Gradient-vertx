# Gradient-vertx
### Линейная регрессия (Теория)
![alt text](https://pp.userapi.com/c844418/v844418351/cf3a5/hPwtNdgpv4w.jpg),
где 

![alt text](https://pp.userapi.com/c844418/v844418351/cf3ac/f-FvWLKU-WM.jpg)

y - вектор наблюдений зависимой переменой y (vectorValues)

x - матрица факторов (vectorRegressors)

b - параметры модели (Theta)

### Метод градиентного спуска (Теория)
Градиентный спуск — метод нахождения локального экстремума (минимума или максимума) функции с помощью движения вдоль градиента.

Нам необходимо подобрать набор коэффициентов 𝜃(theta), который бы минимизировал функцию стоимости.
![alt text](https://pp.userapi.com/c847120/v847120635/c90e0/66h8Hmyq-5g.jpg)

Алгоритм выглядит следующим образом:
1. Инициализация *𝜃 = (1, 1, … 1)*;
1. Вычисление значение *h𝜃(x)* для всех точек;
1. Вычисление значение функции стоимости *J(𝜃)*;
1. *ЕСЛИ* значение функции стоимости *J(𝜃)* меньше порога, 
  *ТО* поиск завершен, перейти на п. 7,
  *ИНАЧЕ* перейти на следующий пункт
1. Изменение значения 𝜃;
1. перейти на п. 2;
1. конец работы;

Изменение значений 𝜃:

![alt text](https://pp.userapi.com/c847120/v847120635/c90e7/o_WbuCWR7tw.jpg)

Все функции для градиентного спуска реализованы в классе **GradientDescent**

### point-generator
Реализован класс для создание файла с исходными данными
Параметрый по умолчанию: 
  1. NAME_OUTPUT_FILES = "set_of_points.data";
  1. DATA_LENGHT = 1000000;
  1. NUMBER_OF_REGRESSORS = 5;
  1. MAX_THETA = 100.0; (максимальный диапазон +-)
  1. MAX_REGRESSOR = 100.0;
  
 ### Список литературы:
 1. https://en.wikipedia.org/wiki/Gradient_descent
 1. https://en.wikipedia.org/wiki/Linear_regression
 1. https://cse.buffalo.edu/faculty/miller/Courses/CSE633/Li-Hui-Fall-2012-CSE633.pdf
 1. https://medium.com/@lachlanmiller_52885/machine-learning-week-1-cost-function-gradient-descent-and-univariate-linear-regression-8f5fe69815fd

