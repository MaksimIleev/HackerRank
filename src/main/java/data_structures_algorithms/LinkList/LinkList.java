package data_structures_algorithms.LinkList;

class LinkList {

    private Link firstLink;

    public LinkList() {
        this.firstLink = null;
    }

    public boolean isEmpty() {
        return firstLink == null;
    }

    public void insertFirstLink(String pageName, int pageId) {
        Link newLink = new Link(pageName, pageId);

        // shift first link to the right
        newLink.setNext(firstLink);

        // newLink becomes first
        firstLink = newLink;
    }

    public Link removeFirst() {
        // reference to the first
        Link linkReference = firstLink;

        if(isEmpty()) {
            System.out.println("Empty LinkList");

        } else {
            // reassign reference to the next
            // of very first link
            firstLink = firstLink.getNext();
        }

        return linkReference;
    }

    public void display() {
        Link link = firstLink;

        while(link != null) {
            System.out.println(link.toString());
            link = link.getNext();
        }
    }

    public Link find(String pageName) {
        Link link = firstLink;

        while(link != null && !(link.getPageName().equalsIgnoreCase(pageName))) {
            link = link.getNext();
        }

        if(link == null) {
            System.out.println("search for " + pageName + " - NOT found");
            return null;
        }
        else {
            System.out.println("search for " + pageName + " - found");
            return link;
        }
    }

    public Link remove(String pageName) {

        Link currentLink = firstLink;
        Link previousLink = firstLink;

        while(currentLink != null && !(currentLink.getPageName().equalsIgnoreCase(pageName))) {
            previousLink = currentLink;
            currentLink = currentLink.getNext();
        }

        if(currentLink == null)
            return null;

        if(currentLink == firstLink) {
            firstLink = firstLink.getNext();
        } else {
            previousLink.setNext(currentLink.getNext());
        }

        return currentLink;
    }

}
