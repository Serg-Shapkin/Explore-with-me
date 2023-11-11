## Explore-with-me
#### (англ. "исследуй со мной")
#### Приложение позволяет пользователям делиться информацией об интересных событиях и находить компанию для участия в них.

### Идея
Свободное время — ценный ресурс. Ежедневно мы планируем, как его потратить — куда и с кем сходить. 
Сложнее всего в таком планировании поиск информации и переговоры. Нужно учесть много деталей: какие намечаются мероприятия, 
свободны ли в этот момент друзья, как всех пригласить и где собраться.
<img width="1440" alt="S19_09-2_1674558748" src="https://github.com/Serg-Shapkin/Explore-with-me/assets/105888354/6a10e933-8037-47ba-ab72-261a24fb3ca8">

### Особенности реализации приложения
1. **Основной сервис** - содержит все необходимое для работы продукта.
   <br> API основного сервиса делится на три части:
   - **публичная** доступна без регистрации любому пользователю, предоставляет возможности поиска и фильтрации событий:
     1. *сортировка списка событий организована либо по количеству просмотров, которое запрашивается в сервисе статистики, либо по датам событий;*
     2. *при просмотре списка событий возвращается только краткая информация о мероприятии;*
     3. *просмотр подробной информации о событии настроен через отдельный эндпоинт;*
     4. *каждое событие относится к какой-то из закрепленных в приложении категорий;*
     5. *настроена возможность получения всех имеющихся категорий и подборок событий (подборки поставляют администраторы ресурса);*
     6. *каждый публичный запрос для получения списка событий или полной информации о мероприятии фиксируется сервисом статистики.*
   - **закрытая** доступна только авторизованным пользователям, реализует возможности зарегистрированным пользователям:
     1. *авторизованные пользователи должны имеют возможность добавлять в приложение новые мероприятия, редактировать их и просматривать после добавления;*
     2. *настроена подача заявок на участие в интересующих мероприятиях;*
     3. *создатель мероприятия имеет возможность подтверждать заявки, которые отправили другие пользователи сервиса.*
   - **административная** доступна для администраторов сервиса, предоставляет  возможности настройки и поддержки работы сервиса:
     1. *настроено добавление, изменение и удаление категорий для событий;*
     2. *возможность добавлять, удалять и закреплять на главной странице подборки мероприятий;*
     3. *модерация событий размещённых пользователями — публикация или отклонение;*
     4. *управление пользователями — добавление, активация, просмотр и удаление.*


2. **Сервис статистики** - хранит количество просмотров и позволяет делать различные выборки для анализа работы приложения.
   <br> Функционал сервиса статистики содержит:
   - запись информации о том, что был обработан запрос к эндпоинту API;
   - представление статистики за выбранные даты по выбранному эндпоинту.


3. **Модель данных**
   <br> Жизненный цикл события включает несколько этапов:
   - создание;
   - ожидание публикации. В статус ожидания публикации событие переходит сразу после создания.
   - публикация. В это состояние событие переводит администратор.
   - отмена публикации. В это состояние событие переходит в двух случаях:
      - первый — если администратор решил, что его нельзя публиковать. 
      - второй — когда инициатор события решил отменить его на этапе ожидания публикации.


4. **Спецификация API**
   <br> Для обоих сервисом Яндекс Практикумом разработаны спецификации:
   - Спецификация основного сервиса: [ewm-main-service-spec.json](https://raw.githubusercontent.com/yandex-praktikum/java-explore-with-me/main/ewm-main-service-spec.json)
   - Спецификация сервиса статистики: [ewm-stats-service.json](https://raw.githubusercontent.com/yandex-praktikum/java-explore-with-me/main/ewm-stats-service-spec.json)
   <br> Для работы со спецификациями рекомендовано использовать Swagger:
     - необходимо скопировать ссылку на файл спецификации
     - открыть онлайн версию редактора [Swagger](https://editor-next.swagger.io/)
     - на верхней панели меню выбрать File, далее Import URL
     - вставить скопированную ссылку в поле появившегося окна, нажать ОК


5. **Фича для самостоятельного проектирования**
   <br> В проекте реализована дополнительная функциональность - рейтинги:
   - возможность ставить лайк/дизлайк событию
   - формирование рейтинга мероприятий и их авторов
   - возможность сортировки событий в зависимости от рейтингов
   <br> Ссылка на пул-реквест с дополнительной функциональностью: [feature_rating-events](https://github.com/Serg-Shapkin/java-explore-with-me/pull/5)
