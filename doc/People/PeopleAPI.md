
# REST API по работе с людьми:

**P.S.** API используется обычное для версии [**Alfresco
5.2 и выше**](https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople).

1. [GET /api/person - **Получить информацио о человеке**](https://api-explorer.alfresco.com/api-explorer/#!/people/getPerson)
   <br>параметры:
   <br>personId - идентификатор пользователя. По умолчанию **-me-**</br>
   <br>Ответ:
```JSON
{
  "entries": [
    {
      "id": "string",
      "name": "string",
      "nodeType": "string",
      "isFolder": true,
      "isFile": true,
      "isLocked": true,
      "modifiedAt": "string",
      "modifiedByUser": {
        "displayName": "string",
        "id": "string"
      },
      "createdAt": "string",
      "createdByUser": {
        "displayName": "string",
        "id": "string"
      },
      "parentId": "string",
      "isLink": true,
      "isFavorite": true,
      "content": {
        "mimeType": "string",
        "mimeTypeName": "string",
        "sizeInBytes": 0,
        "encoding": "string"
      },
      "aspectNames": [
        "string"
      ],
      "properties": {},
      "allowableOperations": [
        "string"
      ],
      "path": {
        "elements": [
          {
            "id": "string",
            "name": "string",
            "nodeType": "string",
            "aspectNames": [
              "string"
            ]
          }
        ],
        "name": "string",
        "isComplete": true
      },
      "permissions": {
        "isInheritanceEnabled": true,
        "inherited": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "locallySet": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "settable": [
          "string"
        ]
      }
    }
  ]
}
```
2. [PUT /api/person - **Изменить**](https://api-explorer.alfresco.com/api-explorer/#!/people/updatePerson)
   <br>параметры:
   <br>personId - идентификатор пользователя.
   <br>В теле передать:
```JSON
{
  "id": "string",
  "firstName": "string",
  "lastName": "string",
  "description": "string",
  "email": "string",
  "skypeId": "string",
  "googleId": "string",
  "instantMessageId": "string",
  "jobTitle": "string",
  "location": "string",
  "company": {
    "organization": "string",
    "address1": "string",
    "address2": "string",
    "address3": "string",
    "postcode": "string",
    "telephone": "string",
    "fax": "string",
    "email": "string"
  },
  "mobile": "string",
  "telephone": "string",
  "userStatus": "string",
  "enabled": true,
  "emailNotificationsEnabled": true,
  "password": "string",
  "aspectNames": [
    "string"
  ],
  "properties": {}
}
```
<br>Ответ:
```JSON
{
  "entries": [
    {
      "id": "string",
      "name": "string",
      "nodeType": "string",
      "isFolder": true,
      "isFile": true,
      "isLocked": true,
      "modifiedAt": "string",
      "modifiedByUser": {
        "displayName": "string",
        "id": "string"
      },
      "createdAt": "string",
      "createdByUser": {
        "displayName": "string",
        "id": "string"
      },
      "parentId": "string",
      "isLink": true,
      "isFavorite": true,
      "content": {
        "mimeType": "string",
        "mimeTypeName": "string",
        "sizeInBytes": 0,
        "encoding": "string"
      },
      "aspectNames": [
        "string"
      ],
      "properties": {},
      "allowableOperations": [
        "string"
      ],
      "path": {
        "elements": [
          {
            "id": "string",
            "name": "string",
            "nodeType": "string",
            "aspectNames": [
              "string"
            ]
          }
        ],
        "name": "string",
        "isComplete": true
      },
      "permissions": {
        "isInheritanceEnabled": true,
        "inherited": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "locallySet": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "settable": [
          "string"
        ]
      }
    }
  ]
}
```
3. [POST /api/group - **Создать**](https://api-explorer.alfresco.com/api-explorer/#!/people/createPerson)
   <br>В теле передать:
```JSON
{
  "id": "string",
  "firstName": "string",
  "lastName": "string",
  "description": "string",
  "email": "string",
  "skypeId": "string",
  "googleId": "string",
  "instantMessageId": "string",
  "jobTitle": "string",
  "location": "string",
  "company": {
    "organization": "string",
    "address1": "string",
    "address2": "string",
    "address3": "string",
    "postcode": "string",
    "telephone": "string",
    "fax": "string",
    "email": "string"
  },
  "mobile": "string",
  "telephone": "string",
  "userStatus": "string",
  "enabled": true,
  "emailNotificationsEnabled": true,
  "password": "string",
  "aspectNames": [
    "string"
  ],
  "properties": {}
}
```
<br>Ответ:
```JSON
{
  "entries": [
    {
      "id": "string",
      "name": "string",
      "nodeType": "string",
      "isFolder": true,
      "isFile": true,
      "isLocked": true,
      "modifiedAt": "string",
      "modifiedByUser": {
        "displayName": "string",
        "id": "string"
      },
      "createdAt": "string",
      "createdByUser": {
        "displayName": "string",
        "id": "string"
      },
      "parentId": "string",
      "isLink": true,
      "isFavorite": true,
      "content": {
        "mimeType": "string",
        "mimeTypeName": "string",
        "sizeInBytes": 0,
        "encoding": "string"
      },
      "aspectNames": [
        "string"
      ],
      "properties": {},
      "allowableOperations": [
        "string"
      ],
      "path": {
        "elements": [
          {
            "id": "string",
            "name": "string",
            "nodeType": "string",
            "aspectNames": [
              "string"
            ]
          }
        ],
        "name": "string",
        "isComplete": true
      },
      "permissions": {
        "isInheritanceEnabled": true,
        "inherited": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "locallySet": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "settable": [
          "string"
        ]
      }
    }
  ]
}
```
4. DELETE /api/group - **Удалить**
   <br>параметры:
   <br>personId - идентификатор пользователя.
   <br><br/>
   <br>Ответ:
```JSON
204
```
5. [GET /api/people/one - **Получить пользователей с сортировкой по одному параметру**](https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople)
   <br>параметры:
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - **100**.
   <br>orderByOne - Сортировка результата по одному из значений (по умолчанию **id**):
   + id.
   + firstName.
   + lastName.
   <br><br/>
   <br>Ответ:
```JSON
{
  "entries": [
    {
      "id": "string",
      "name": "string",
      "nodeType": "string",
      "isFolder": true,
      "isFile": true,
      "isLocked": true,
      "modifiedAt": "string",
      "modifiedByUser": {
        "displayName": "string",
        "id": "string"
      },
      "createdAt": "string",
      "createdByUser": {
        "displayName": "string",
        "id": "string"
      },
      "parentId": "string",
      "isLink": true,
      "isFavorite": true,
      "content": {
        "mimeType": "string",
        "mimeTypeName": "string",
        "sizeInBytes": 0,
        "encoding": "string"
      },
      "aspectNames": [
        "string"
      ],
      "properties": {},
      "allowableOperations": [
        "string"
      ],
      "path": {
        "elements": [
          {
            "id": "string",
            "name": "string",
            "nodeType": "string",
            "aspectNames": [
              "string"
            ]
          }
        ],
        "name": "string",
        "isComplete": true
      },
      "permissions": {
        "isInheritanceEnabled": true,
        "inherited": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "locallySet": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "settable": [
          "string"
        ]
      }
    }
  ]
}
```
6. [GET /api/people/two - **Получить пользователей с сортировкой по двум параметрам**](https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople)
   <br>параметры:
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - **100**.
   <br>orderByOne - Сортировка результата по одному из значений (по умолчанию **firstName**):
   + id.
   + firstName.
   + lastName.
   <br>orderByTwo - Сортировка результата по одному из значений (по умолчанию **lastName**):
   + id.
   + firstName.
   + lastName.
   <br><br/>
   <br>Ответ:
```JSON
{
  "entries": [
    {
      "id": "string",
      "name": "string",
      "nodeType": "string",
      "isFolder": true,
      "isFile": true,
      "isLocked": true,
      "modifiedAt": "string",
      "modifiedByUser": {
        "displayName": "string",
        "id": "string"
      },
      "createdAt": "string",
      "createdByUser": {
        "displayName": "string",
        "id": "string"
      },
      "parentId": "string",
      "isLink": true,
      "isFavorite": true,
      "content": {
        "mimeType": "string",
        "mimeTypeName": "string",
        "sizeInBytes": 0,
        "encoding": "string"
      },
      "aspectNames": [
        "string"
      ],
      "properties": {},
      "allowableOperations": [
        "string"
      ],
      "path": {
        "elements": [
          {
            "id": "string",
            "name": "string",
            "nodeType": "string",
            "aspectNames": [
              "string"
            ]
          }
        ],
        "name": "string",
        "isComplete": true
      },
      "permissions": {
        "isInheritanceEnabled": true,
        "inherited": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "locallySet": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "settable": [
          "string"
        ]
      }
    }
  ]
}
```
7. [GET /api/people/three - **Получить пользователей с сортировкой по трём параметрам**](https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople)
   <br>параметры:
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - **100**.
   <br>orderByOne - Сортировка результата по одному из значений (по умолчанию **id**):
   + id.
   + firstName.
   + lastName.
   <br>orderByTwo - Сортировка результата по одному из значений (по умолчанию **firstName**):
   + id.
   + firstName.
   + lastName.
   <br>orderByThree - Сортировка результата по одному из значений (по умолчанию **lastName**):
   + id.
   + firstName.
   + lastName.
   <br><br/>
   <br>Ответ:
```JSON
{
  "entries": [
    {
      "id": "string",
      "name": "string",
      "nodeType": "string",
      "isFolder": true,
      "isFile": true,
      "isLocked": true,
      "modifiedAt": "string",
      "modifiedByUser": {
        "displayName": "string",
        "id": "string"
      },
      "createdAt": "string",
      "createdByUser": {
        "displayName": "string",
        "id": "string"
      },
      "parentId": "string",
      "isLink": true,
      "isFavorite": true,
      "content": {
        "mimeType": "string",
        "mimeTypeName": "string",
        "sizeInBytes": 0,
        "encoding": "string"
      },
      "aspectNames": [
        "string"
      ],
      "properties": {},
      "allowableOperations": [
        "string"
      ],
      "path": {
        "elements": [
          {
            "id": "string",
            "name": "string",
            "nodeType": "string",
            "aspectNames": [
              "string"
            ]
          }
        ],
        "name": "string",
        "isComplete": true
      },
      "permissions": {
        "isInheritanceEnabled": true,
        "inherited": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "locallySet": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "settable": [
          "string"
        ]
      }
    }
  ]
}
```
8. [GET /api/people/list - **Получить пользователей с "гибкими" параметрами**](https://api-explorer.alfresco.com/api-explorer/#!/people/listPeople)
   <br>параметры:</br>
   <br>skipCount - Количество сущностей, которые существуют в коллекции до тех, которые включены в этот список. Если не
   указан, то значение по умолчанию - **0**.</br>
   <br>maxItems - Максимальное количество элементов для возврата в список. Если не указан, то значение по умолчанию - **100**.</br>
   <br>orderBy - Сортировка результата по одному из значений (по умолчанию **id**):
   + id.
   + firstName.
   + lastName.</br>

   <br>include - Возвращает дополнительную информацию о человеке. Могут быть запрошены следующие необязательные поля:
   + properties.
   + aspectNames.
   + capabilities.</br>
 
   <br>fields - Список имен полей. Вы можете использовать этот параметр, чтобы ограничить поля, возвращаемые в ответе, если, например, вы хотите сэкономить на общей пропускной способности. Список применяется к возвращаемой отдельной сущности или записям в коллекции. Если метод API также поддерживает параметр include, то поля, указанные в параметре include, возвращаются в дополнение к тем, которые указаны в параметре fields.</br>
   <br>Ответ:
```JSON
{
  "entries": [
    {
      "id": "string",
      "name": "string",
      "nodeType": "string",
      "isFolder": true,
      "isFile": true,
      "isLocked": true,
      "modifiedAt": "string",
      "modifiedByUser": {
        "displayName": "string",
        "id": "string"
      },
      "createdAt": "string",
      "createdByUser": {
        "displayName": "string",
        "id": "string"
      },
      "parentId": "string",
      "isLink": true,
      "isFavorite": true,
      "content": {
        "mimeType": "string",
        "mimeTypeName": "string",
        "sizeInBytes": 0,
        "encoding": "string"
      },
      "aspectNames": [
        "string"
      ],
      "properties": {},
      "allowableOperations": [
        "string"
      ],
      "path": {
        "elements": [
          {
            "id": "string",
            "name": "string",
            "nodeType": "string",
            "aspectNames": [
              "string"
            ]
          }
        ],
        "name": "string",
        "isComplete": true
      },
      "permissions": {
        "isInheritanceEnabled": true,
        "inherited": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "locallySet": [
          {
            "authorityId": "string",
            "name": "string",
            "accessStatus": "string"
          }
        ],
        "settable": [
          "string"
        ]
      }
    }
  ]
}
```