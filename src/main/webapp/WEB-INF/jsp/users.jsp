<%@ page import="novella_models.users.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rumro
  Date: 15.10.2024
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <div>
        <%
            List<User> users = (List<User>) request.getAttribute("List users");
            for (User user : users) {
                out.print(user.getLogin());
                out.print(user.getPassword());
            }
        %>
    </div>
    <img src="<% out.print(request.getContextPath());%>/hell.jpg">

    <div class="quest-item quest-item--vertical" data-entity="items-row">
        <div class="quest-item__top">
            <div class="quest-item__age quest-age">14+</div>
            <div class="quest-item__new">new</div>
            <a href="/poisk-kvestov/quest-stars-obitel-proklyatykh/" class="quest-item__image" target="_blank">
                <img data-src="/upload/ammina.optimizer/jpg-webp/q80/upload/iblock/56h/56hpyl6k9259hl16ic6vbcj9ib3ug26r.webp" alt="Обитель проклятых" title="Перформанс Обитель проклятых" src="/upload/ammina.optimizer/jpg-webp/q80/upload/iblock/56h/56hpyl6k9259hl16ic6vbcj9ib3ug26r.webp" class="lazy-loaded"></a>
            <div class="quest-item__overlay">
                <div class="quest-item__aligner aligner">
                    <div class="quest-item__scale quest-stat quest-stat--difficulty-1">
                        <div class="aligner">
                            <div class="quest-stat__caption">Сложность</div>
                            <div class="clearfix">
                                <div class="quest-stat__segment is-full"></div>
                                <div class="quest-stat__segment is-full"></div>
                                <div class="quest-stat__segment "></div>
                                <div class="quest-stat__segment "></div>
                            </div>
                        </div>
                    </div>
                    <div class="quest-item__scale quest-stat quest-stat--horror-1">
                        <div class="aligner">
                            <div class="quest-stat__caption">Страх</div>
                            <div class="clearfix">
                                <div class="quest-stat__segment is-full"></div>
                                <div class="quest-stat__segment is-full"></div>
                                <div class="quest-stat__segment is-full"></div>
                                <div class="quest-stat__segment is-full"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="quest-item__mid">
            <div class="clearfix">
                <div class="quest-item__type">Перформанс</div>
                <div class="quest-item__rating quest-stat quest-stat--small quest-stat--rating">9.8</div>
            </div>
            <h3 class="quest-item__title page-title">
                <a href="/poisk-kvestov/quest-stars-obitel-proklyatykh/" title="Перформанс Обитель проклятых" target="_blank">Обитель проклятых</a>
            </h3>
            <div class="clearfix">
                <div class="quest-item__stat quest-stat quest-stat--small quest-stat--time-1">
                    60 минут
                </div>
                <div class="quest-item__stat quest-stat quest-stat--small quest-stat--size-1">
                    1-12                                    игроков                                </div>
            </div>
            <p class="quest-item__brief">Народная мудрость гласит, что скупой теряет последнее, желая достать все. Так вы в один злополучный день стали жертвой страшнейшего из людских пороков</p>
        </div>
        <div class="quest-item__bot clearfix">
            <div class="quest-item__cost quest-stat quest-stat--cost-1" data-entity="price-block">
                         <span>
                            от 5500 руб.                        </span>
            </div>
            <div data-entity="buttons-block">
                <a class="quest-item__buy button button--medium button--transparent-red" href="/poisk-kvestov/quest-stars-obitel-proklyatykh/" target="_blank">
                    Бронировать
                </a>
            </div>
            <div class="quest-item__fav quest-fav">
            </div>
        </div>
    </div>
</head>
<body>

</body>
</html>
