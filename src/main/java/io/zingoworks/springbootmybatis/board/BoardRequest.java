package io.zingoworks.springbootmybatis.board;

public class BoardRequest {

    private String title;
    private String content;

    //??? 디폴트생성자 필요한 경우, 필요하지 않은 경우 구분
    protected BoardRequest() {}

    public BoardRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Board toBoard() {
        return new Board(title, content);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BoardRequest{");
        sb.append("title='").append(title).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
