#include <iostream>
#include <array>

using namespace std;

template <class T>
class heap {
    private:
        int size;
        T* items;
    public:
        heap(int);
        ~heap();
	void remove();
        void insert(T);
        void display();
};

template <class T>
heap<T>::heap(int num) {
    size = 0;
    items = new T[num + 1];
}

template <class T>
heap<T>::~heap() {
    delete[] items;
}

template <class T>
void heap<T>::insert(T item) {
    if (size == 0)
        items[++size] = item;
    else{
        int i = ++size;
        items[i] = item;
        int temp;
        while ( i / 2 > 0){
            if(items[i] < items[i / 2]) {
                temp = items[i];
                items[i] = items[i / 2];
                items[i / 2] = temp;
                i = i / 2;
            } else {
                break;
            }
        }
    }      
}

template <class T>
void heap<T>::remove(){
    if (size != 0){
        
        int i = 1;
        int curr = items[size];
        while ((i * 2) < size && (i * 2 + 1) < size){
            if (curr > items[i * 2] || curr > items[i * 2 + 1]) {
                if (items[i * 2] < items[i * 2 + 1]){
                    items[i] = items[i * 2];
                    i = i * 2;
                } else {
                    items[i] = items[i * 2 + 1];
                    i = i * 2 + 1;
                }
            } else {
                break;
            }
        }
        if (i * 2 < size && curr > items[i * 2]){
            items[i] = items[i * 2];
            items[i * 2] = curr;
        } else if ((i * 2 + 1) < size && curr > items[i * 2 + 1]){
            items[i] = items[i * 2 + 1];
            items[i * 2 + 1] = curr;
        } else {
            items[i] = curr;
        }
        size--;
    }
}

template <class T>
void heap<T>::display() {
    for(int i = 1; i < size + 1; i++) {
        cout << items[i] << " ";
    }
    cout << endl;
}

int main() {

    int cases, elements, del;
    cin >> cases;
    while(cases > 0) {
        cin >> elements;
        heap<int> h(elements);
        while(elements > 0) {
            int item;
            cin >> item;
            h.insert(item);           
            elements--;
        }
        cin >> del;
        for (int i = 0; i < del; i++){
            h.remove();
            h.display();
        }
        cases--;
    }
    return 0;
}
