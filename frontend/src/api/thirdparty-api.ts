
export function getYandexMapsLink(latitude: number, longitude: number, zoom: number | undefined) {
    return `https://yandex.ru/maps/?ll=${longitude},${latitude}&z=${zoom ?? 18}`
}
