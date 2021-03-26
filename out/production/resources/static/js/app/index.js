var main = {
    init : function () {
        var _this = this;

        var page = $("ul").data("page");
        var endPage = $("div").data("endPage");

        if (page > 1) {
            var one = page + -2;
            var two = page + -1;
            var three = page;
            var four = page + 1;
            var five = page + 2;

            $("#one").attr("href", "/page?page=" + one)
            $("#two").attr("href", "/page?page=" + two)
            $("#three").attr("href", "/page?page=" + three)
            $("#four").attr("href", "/page?page=" + four)
            $("#five").attr("href", "/page?page=" + five)

            $("#one").text(++one);
            $("#two").text(++two);
            $("#three").text(++three);
            $("#four").text(++four);
            $("#five").text(++five);
        }
    }
};

main.init();