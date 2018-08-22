# Gradient-vertx
### Линейная регрессия (Теория)
![alt text](https://pp.userapi.com/c844418/v844418351/cf3a5/hPwtNdgpv4w.jpg),
где 

![alt text](https://pp.userapi.com/c844418/v844418351/cf3ac/f-FvWLKU-WM.jpg)

y - вектор наблюдений зависимой переменой y (vectorValues)

x - матрица факторов (vectorRegressors)

b - параметры модели (Theta)
### point-generator
Реализован класс для создание файла с исходными данными
Параметрый по умолчанию: 
  1. NAME_OUTPUT_FILES = "set_of_points.data";
  1. DATA_LENGHT = 1000000;
  1. NUMBER_OF_REGRESSORS = 5;
  1. MAX_THETA = 100.0; (максимальный диапазон +-)
  1. MAX_REGRESSOR = 100.0;
