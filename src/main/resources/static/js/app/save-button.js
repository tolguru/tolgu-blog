var main = {
    init : function () {
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },

    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };


        if(this.emptyCheck(data.title, data.author, data.content)) {
            $.ajax({
                type: 'POST',
                url: '/api/v1/posts',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data: JSON.stringify(data)
            }).done(function() {
                alert('글이 등록되었습니다.');
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
        }
    },

    emptyCheck : function(title, author, content) {
        if(title.trim().length <= 0) {
            alert('제목을 적어주세요')
            return false
        }
        else if(author.trim().length <= 0) {
            alert('작성자를 적어주세요')
            return false
        }
        else if(content.trim().length <= 0) {
            alert('내용을 적어주세요')
            return false
        }

        return true;
    }
};

main.init();