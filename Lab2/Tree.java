//package com.company;

public class Tree {
    private Node rootNode; // корневой узел
    public Tree() { // Пустое дерево
        rootNode = null;
    }
    public Node Search(int value) { // поиск узла по значению
        Node currentNode = rootNode; // начинаем поиск с корневого узла
        while (currentNode.getValue() != value) { // поиск покуда не будет найден элемент или не будут перебраны все
            if (value < currentNode.getValue()) { // движение влево
                currentNode = currentNode.getLeftChild();
            } else { //движение вправо
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null) { // если потомка нет,
                return null; // возвращаем null
            }
        }
        return currentNode; // возвращаем найденный элемент
    }
    public void Insert(int value) { // метод вставки нового элемента
        Node newNode = new Node(); // создание нового узла
        newNode.setValue(value); // вставка данных
        if (rootNode == null) { // если корневой узел не существует
            rootNode = newNode;// то новый элемент и есть корневой узел
        }
        else { // корневой узел занят
            Node currentNode = rootNode; // начинаем с корневого узла
            Node parentNode;
            while (true) // мы имеем внутренний выход из цикла
            {
                parentNode = currentNode;
                if(value == currentNode.getValue()) {   // если такой элемент в дереве уже есть, не сохраняем его
                    return;    // просто выходим из метода
                }
                else  if (value < currentNode.getValue()) {   // движение влево
                    currentNode = currentNode.getLeftChild();
                    if (currentNode == null){ // если был достигнут конец цепочки,
                        parentNode.setLeftChild(newNode); //  то вставить слева и выйти из методы
                        return;
                    }
                }
                else { // Или направо?
                    currentNode = currentNode.getRightChild();
                    if (currentNode == null) { // если был достигнут конец цепочки,
                        parentNode.setRightChild(newNode);  //то вставить справа
                        return; // и выйти
                    }
                }
            }
        }
    }
    public boolean Remove(int value) // Удаление узла с заданным ключом
    {
        Node currentNode = rootNode;
        Node parentNode = rootNode;
        boolean isLeftChild = true;
        while (currentNode.getValue() != value) { // начинаем поиск узла
            parentNode = currentNode;
            if (value < currentNode.getValue()) { // Определяем, нужно ли движение влево?
                isLeftChild = true;
                currentNode = currentNode.getLeftChild();
            }
            else { // или движение вправо?
                isLeftChild = false;
                currentNode = currentNode.getRightChild();
            }
            if (currentNode == null)
                return false; // yзел не найден
        }

        if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) { // узел просто удаляется, если не имеет потомков
            if (currentNode == rootNode) // если узел - корень, то дерево очищается
                rootNode = null;
            else if (isLeftChild)
                parentNode.setLeftChild(null); // если нет - узел отсоединяется, от родителя
            else
                parentNode.setRightChild(null);
        }
        else if (currentNode.getRightChild() == null) { // узел заменяется левым поддеревом, если правого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getLeftChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getLeftChild());
            else
                parentNode.setRightChild(currentNode.getLeftChild());
        }
        else if (currentNode.getLeftChild() == null) { // узел заменяется правым поддеревом, если левого потомка нет
            if (currentNode == rootNode)
                rootNode = currentNode.getRightChild();
            else if (isLeftChild)
                parentNode.setLeftChild(currentNode.getRightChild());
            else
                parentNode.setRightChild(currentNode.getRightChild());
        }
        else { // если есть два потомка, узел заменяется преемником
            Node heir = receiveHeir(currentNode);// поиск преемника для удаляемого узла
            if (currentNode == rootNode)
                rootNode = heir;
            else if (isLeftChild)
                parentNode.setLeftChild(heir);
            else
                parentNode.setRightChild(heir);
        }
        return true; // элемент успешно удалён
    }
    private Node receiveHeir(Node node) {
        Node parentNode = node;
        Node heirNode = node;
        Node currentNode = node.getRightChild(); // Переход к правому потомку
        while (currentNode != null) // Пока остаются левые потомки
        {
            parentNode = heirNode;// потомка задаём как текущий узел
            heirNode = currentNode;
            currentNode = currentNode.getLeftChild(); // переход к левому потомку
        }
        // Если преемник не является
        if (heirNode != node.getRightChild()) // правым потомком,
        { // создать связи между узлами
            parentNode.setLeftChild(heirNode.getRightChild());
            heirNode.setRightChild(node.getRightChild());
        }
        return heirNode;// возвращаем приемника
    }
}
