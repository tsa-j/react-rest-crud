import Configuration from './configuration';

class ItemService {

  constructor() {
    this.config = new Configuration();
  }

  async retrieveItems() {
    return fetch(this.config.ITEM_COLLECTION_URL)
      .then(response => {
        if (!response.ok) {
            this.handleResponseError(response);
        }
        return response.json();
      })
      .then(json => {

        console.log("this.config.ITEM_COLLECTION_URL :" +this.config.ITEM_COLLECTION_URL);
        console.log("Retrieved items:");
        console.log(json);
        const items = [];
        const itemArray = json;
        for(let i = 0; i < itemArray.length; i++) {
         // itemArray[i]["link"] =  i;
          items.push(itemArray[i]);
        }
        return items;
      })
      .catch(error => {
        this.handleError(error);
      });
  }

  async getItem(itemLink) {
    console.log("ItemService.getItem():");
    console.log("Item: " + itemLink);
    return fetch(this.config.ITEM_COLLECTION_URL+"/"+itemLink)
      .then(response => {
        if (!response.ok) {
            this.handleResponseError(response);
        }
        return response.json();
      })
      .then(item => {
        //  item["link"] = item._links.self.href;
          let newItem = item;
          return newItem;
        }
      )
      .catch(error => {
        this.handleError(error);
      });
  }

  async createItem(newitem) {
    console.log("ItemService.createItem():");
    console.log(newitem);
    return fetch(this.config.ITEM_COLLECTION_URL, {
      method: "POST",
      mode: "cors",
      headers: {
            "Content-Type": "application/json"
        },
      body: JSON.stringify(newitem)
    })
      .then(response => {
        if (!response.ok) {
            this.handleResponseError(response);
        }
        return response.json();
      })
      .catch(error => {
        this.handleError(error);
          console.log(error);
      });
  }

  async deleteItem(itemlink) {
    console.log("ItemService.deleteItem():");
    console.log("item: " + itemlink);
    return fetch(this.config.ITEM_COLLECTION_URL+"/"+itemlink, {
      method: "DELETE",
      mode: "cors"
    })
      .then(response => {
        if (!response.ok) {
            this.handleResponseError(response);
        }
      })
      .catch(error => {
        this.handleError(error);
      });
  }

  async updateItem(item) {
    console.log("ItemService.updateItem():");
    console.log(item);
    return fetch(this.config.ITEM_COLLECTION_URL+"/"+item.link, {
      method: "PUT",
      mode: "cors",
      headers: {
            "Content-Type": "application/json"
          },
      body: JSON.stringify(item)
    })
      .then(response => {
        if (!response.ok) {
          this.handleResponseError(response);
        }
        return response.json();
      })
      .catch(error => {
        this.handleError(error);
      });
  }

  handleResponseError(response) {
      throw new Error("HTTP error, status = " + response.status);
  }

  handleError(error) {
      console.log(error.message);
  }
}

export default ItemService;
