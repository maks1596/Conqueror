# Conqueror
Приложение-игра на счёт. 

# Техническое задание
Основные сущности:
- Отряд
  - Название отряда
  - Численность отряда
- Территория
  - Название
  - Количество монет за удачный поход на территорию
  - Вероятность удачного похода на территорию
  - Расстояние до территории

В приложении должны быть следующие экраны:
- Основной экран
- Экран для выбора территории

## Основной экран

На основном экране приложения отображается:
- Название приложения
- Текущая численность населения королевства
- Количество монет в казне королевства
- Список доступных отрядов
- Список недоступных отрядов

Для каждого элемента списка отрядов отображается:
- Название отряда
- Его численность

Недоступные отряды - отряды численность которых больше, чем численность населения королевства.

Отряды отсортированы по возрастанию численности.

При нажатии на элемент списка доступных отрядов, открывает экран для выбора захвачеваемой территории.

На основном экране приложения должна быть возможность пополнять численность королевства за монеты.

## Экран выбора территории
На экране выбора территории отображается список выбора территории для захвата выбранным отрядом.  
Для каждого элемента списка выбора территории отображается:
- Название территории
- Вероятность удачного похода на территорию
- Размер награды за удачный поход на территорию
  
Список территорий отсортирован по возрастанию расстояния до них.  
Чем дальше находится территория, тем выше награда за неё, но меньше вероятность удачного похода.  
Награда за удачный поход на территорию рассчитывается в зависимости от размера выбранного отряда.

При нажатии на элемент списка выбора территории отряд отправляется в поход. На экране появляется прогресс текущего состояния похода отряда. Длительность показа прогресса тем дольше, чем больше расстояние до выбранной территории. 

Если поход на территорию успешный, то:
- Пользователю показывается сообщение об удачном походе.  
- Отряд полностью возвращается обратно в королевство. На экране отображается прогресс возврата отряда в королевство. Длительность возврата равна длительности похода до территории.

Если поход на территорию прошёл неудачно, то:
- Пользователю показывается сообщение о неудачном походе.
- Отряд обратно не возвращается.

После фазы похода (удачного или неудачного) пользователь возвращается на основной экран приложения.  
Если поход был неудачный, то у пользователя снимается численность населения королевства равная численности отправленного в поход отряда.  
Если поход прошёл успешно, то в казну королевства пользователя добавляется количество монет, полученных в награду за удачный поход.

---
### Технические требования
- Минимальная версия SDK Android = 22
- Используется только язык Kotlin
- Приложение не должно сохранять состояние между перезапусками.
- Приложение должно быть устойчиво к желанию Android почистить память.
- Рекомендуемый архитектурный паттерн - VIPER
  - Хорошо ложится на кросс-платформу
  - Есть регламентированный слой под логику
- Главный экран приложения содержит *один* список с *разными* типами элементов
