package data_structures_algorithms.LinkList;

public class Link {

    private String pageName;
    private int pageId;
    private Link next;

    public Link(String pageName, int pageId) {
        this.pageName = pageName;
        this.pageId = pageId;
    }

    public static void main(String... args) {
        LinkList linkList = new LinkList();
        linkList.insertFirstLink("firstPage", 1);
        linkList.insertFirstLink("secondPage", 2);
        linkList.insertFirstLink("thirdPage", 3);
        linkList.insertFirstLink("fourthPage", 4);

        linkList.display();
        Link link = linkList.find("firstPage");
        System.out.println(link.toString());

        linkList.remove("firstPage");
        linkList.display();
    }

    public String toString() {
        return "Page Name: " + pageName + " with id: " + pageId;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public int getPageId() {
        return pageId;
    }

    public void setPageId(int pageId) {
        this.pageId = pageId;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }
}

