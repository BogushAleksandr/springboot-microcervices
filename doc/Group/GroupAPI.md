
# REST API по работе с группой:

**P.S.** API группы используется с локальной Альфрески так как обычное API используется только для версии [**Alfresco
5.2.1 и выше**](https://api-explorer.alfresco.com/api-explorer/#!/groups/listGroups).

1. GET /api/group - **Получить информацио о группе**
   <br>параметры:
   <br>groupId - индификатор группы т.е. её имя.</br>
   <br>Ответ:
```JSON
{
  "authorityType": "string",
  "shortName": "string",
  "fullName": "string",
  "displayName": "string",
  "url": "string",
  "zones": [
    "string"
  ]
}
```
2. PUT /api/group - **Изменить**
   <br>параметры:
   <br>shortGroupName - индификатор группы т.е. её имя.
   <br>В теле передать:
```JSON
{
  "displayName": "string"
}
```
<br>Ответ:
```JSON
{
  "authorityType": "string",
  "shortName": "string",
  "fullName": "string",
  "displayName": "string",
  "url": "string",
  "zones": [
    "string"
  ]
}
```
3. POST /api/group - **Создать**
   <br>параметры:
   <br>shortGroupName - индификатор группы т.е. её имя.
   <br>В теле передать:

```JSON
{
  "id": "string",
  "displayName": "string",
  "parentIds": [
    "string"
  ]
}
```
<br>Ответ:
```JSON
{
  "authorityType": "string",
  "shortName": "string",
  "fullName": "string",
  "displayName": "string",
  "url": "string",
  "zones": [
    "string"
  ]
}
```
4. DELETE /api/group - **Удалить**
   <br>параметры:
   <br>shortGroupName - индификатор группы т.е. её имя.
   <br><br/>
   <br>Ответ:
```JSON
204
```
5. GET /api/groups/parents - **Получить родителей**
   <br>параметры:
   <br>shortGroupName - индификатор группы т.е. её имя.
   <br>skipCount - Количество сущностей, которые существуют в коллекции до тех, которые включены в этот список. Если не
   указан, то значение по умолчанию - 0.
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - 100.
   <br><br/>
   <br>Ответ:
```JSON
{
   "data": [
      {
         "authorityType": "string",
         "shortName": "string",
         "fullName": "string",
         "displayName": "string",
         "url": "string",
         "zones": [
            "string"
         ]
      }
   ]
}
```
6. GET /api/groups/children/filter - **Получить все группы с использованием дополнительных параметров**
   <br>параметры:
   <br>shortGroupName - индификатор группы т.е. её имя.
   <br>authorityType - USER или GROUP. По умолчанию USER.
   <br>skipCount - Количество сущностей, которые существуют в коллекции до тех, которые включены в этот список. Если не
   указан, то значение по умолчанию - 0.
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - 100.
   <br><br/>
   <br>Ответ:
```JSON
{
   "data": [
      {
         "authorityType": "string",
         "shortName": "string",
         "fullName": "string",
         "displayName": "string",
         "url": "string",
         "zones": [
            "string"
         ]
      }
   ]
}
```
7. GET /api/groups/children - **Получить все дочерние группы**
   <br>параметры:
   <br>shortGroupName - индификатор группы т.е. её имя.
   <br>skipCount - Количество сущностей, которые существуют в коллекции до тех, которые включены в этот список. Если не
   указан, то значение по умолчанию - 0.
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - 100.
   <br><br/>
   <br>Ответ:
```JSON
{
   "data": [
      {
         "authorityType": "string",
         "shortName": "string",
         "fullName": "string",
         "displayName": "string",
         "url": "string",
         "zones": [
            "string"
         ]
      }
   ]
}
```
8. GET /api/groups - **Получить все группы**
   <br>параметры:
   <br>shortGroupName - индификатор группы т.е. её имя.
   <br>skipCount - Количество сущностей, которые существуют в коллекции до тех, которые включены в этот список. Если не
   указан, то значение по умолчанию - 0.
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - 100.
   <br></br>
   <br>Ответ:
```JSON
{
   "data": [
      {
         "authorityType": "string",
         "shortName": "string",
         "fullName": "string",
         "displayName": "string",
         "url": "string",
         "zones": [
            "string"
         ]
      }
   ]
}
```