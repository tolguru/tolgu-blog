var main = {
    init : function () {
        const totalPage = $("#totalPage").data('totalpage');
        const nowPage = $("#nowPage").data('nowpage');
        // 하단에 보일 페이지 번호 수
        const maxPageView = 5;
        let pageView = maxPageView;

        let isEndList = false;

        var pageDivTag = $("#page-button");

        // 마지막 페이지 계산
        const endPage = totalPage - 1;
        // 노출될 페이지 번호를 나타내기 위함
        let pageDivision = parseInt(nowPage / maxPageView + 1) * maxPageView;
        const pageButtonNum = pageDivision - 5;

        // 마지막 페이지가 현재 구간보다 작을 시 최대 페이지로 설정해서 마지막 페이지까지만 표시
        if (totalPage <= pageDivision) {
            pageDivision = totalPage;
            isEndList = true;

            // 노출될 페이지 버튼 개수를 나머지로 계산
            pageView = totalPage % maxPageView;

            if (totalPage % maxPageView == 0) {
                pageView = maxPageView;
            }
        }

        for(var i = 1; i <= pageView; i++) {
            pageDivTag.append($('<li id="li_'+ i +'" class="page-item"><a id="page_'+ i +'" class="page-link"></a></li>'));
            $("#page_" + i).text((pageButtonNum + i));
            $("#page_" + i).attr('href', '/?page='+ (pageButtonNum + i - 1) +'');
        }

        // 클릭된 페이지 식별 후 색 변동
        let clickedButtonId = nowPage % maxPageView + 1;
        $("#li_" + clickedButtonId).attr('class', 'page-item active');

        if (!isEndList) {
            pageDivTag.append($('<li class="page-item"><a class="page-link" href="/?page='+ pageDivision +'"><span>></span></a></li>'));
        }

        if (nowPage < 5) {
            $("#prev").remove();
        }
        else {
            $("#prev").attr('href', '/?page='+ (pageDivision - maxPageView - 1) +'');
        }
    }
};

main.init();