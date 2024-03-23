package hello.springmvc.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();

    @AfterEach
    void afterEach() {
        itemRepository.clearStore();
    }

    @Test
    void save() {
        Item item = new Item("itemA", 1000, 10);

        Item saveItem = itemRepository.save(item);

        Item findItem = itemRepository.findById(saveItem.getId());
        assertThat(findItem).isEqualTo(saveItem);
    }

    @Test
    void findAll() {
        Item item1 = new Item("item1", 1000, 10);
        Item item2 = new Item("item2", 1000, 10);
        itemRepository.save(item1);
        itemRepository.save(item2);

        List<Item> itemList = itemRepository.findAll();

        assertThat(itemList.size()).isEqualTo(2);
        assertThat(itemList).contains(item1, item2);
    }

    @Test
    void updateItem() {
        Item item = new Item("item1", 1000, 10);
        Item saveItem = itemRepository.save(item);
        Long itemId = saveItem.getId();

        Item updateParam = new Item("item2", 2000, 20);

        itemRepository.update(itemId, updateParam);

        Item findItem = itemRepository.findById(itemId);

        assertThat(findItem.getItemName()).isEqualTo(updateParam.getItemName());
        assertThat(findItem.getPrice()).isEqualTo(updateParam.getPrice());
        assertThat(findItem.getQuantity()).isEqualTo(updateParam.getQuantity());
    }


}