# Adore Hair Studio

Adore Hair Studio is a full-stack hair studio and e-commerce website for displaying wigs and other products, services, testimonials, reviews, contact information, and managing content through an admin console.

## Technology and tools used

### Frontend
- **HTML5** — page structure and content.
- **CSS3** — responsive layout, black/gold visual design, cards, modals, forms, animations, and dark mode.
- **JavaScript (Vanilla JS)** — product loading, search, cart, product gallery, reviews, settings integration, admin interactions, and theme switching.
- **Google Fonts** — Playfair Display and Poppins typography.
- **Font Awesome** — interface icons.
- **Browser Local Storage** — remembers the selected light/dark theme and other client-side preferences.

### Backend
- **Java** — backend programming language.
- **Spring Boot** — REST API and server-side application framework.
- **PostgreSQL** — relational database for products, services, settings, testimonials, reviews, and related application data.
- **REST API** — connects the frontend to the Spring Boot backend.
- **JWT authentication** — protects admin API operations.

### Development tools
- **Visual Studio Code** — code editing and project development.
- **Git** — source-code version control.
- **Git Bash** — running Git and project commands on Windows.
- **GitHub** — remote source-code repository and version history.
- **Uptimerobot** - keep the site awake every 5 minutes. https://dashboard.uptimerobot.com

### Deployment / hosting
- **Vercel** — hosts the public frontend website.
- **Render** — hosts the Spring Boot backend/API.
- **PostgreSQL on the backend environment** — stores the application's persistent data.

### Optional uptime support
- **UptimeRobot** can be used to send a request to the Render API every 5 minutes while the backend is on Render's Free service. This can reduce the visible cold-start delay caused by an idle Render service.

## Main features

- Product catalogue with **Wigs** and **Other Products** groups.
- Product search.
- Product descriptions with **Read More** details.
- Multiple product images and product gallery.
- Featured / best-seller products.
- Shopping cart and checkout flow.
- Product reviews and ratings.
- Services section.
- Testimonials.
- Admin product management.
- Admin list/grid display.
- Product added date and time.
- Homepage hero settings.
- Contact and social-media settings controlled from the admin console.
- Responsive mobile navigation.
- Light/dark mode toggle on the public website.
- Light/dark mode toggle on the admin console.
- Theme preference is remembered with browser Local Storage.

## Dark mode

The current update adds an animated light/dark switch to:

1. The public Adore Hair Studio website.
2. The admin console.

The public website stores its theme using:

`adore_theme`

The admin console stores its theme using:

`adore_admin_theme`

The theme is applied before the page finishes loading so the selected mode can be restored after a refresh.

## Deployment structure

```text
Adore Hair Studio
│
├── frontend/
│   └── index.html          → Vercel public website
│
└── backend/
    └── Spring Boot API     → Render backend
        └── static/
            └── admin.html  → Admin console
```

## Applying the latest dark-mode update

Replace these two files in the existing repository:

```text
frontend/index.html
backend/src/main/resources/static/admin.html
```

Then from the repository root run:

```bash
git status
git add frontend/index.html backend/src/main/resources/static/admin.html README.md
git commit -m "Add dark mode and document project tools"
git push origin main
```

After Vercel deploys the frontend, do a hard refresh in the browser with **Ctrl + Shift + R**.

Because `admin.html` is part of the Spring Boot backend, Render must also redeploy the backend for the admin-console dark mode to appear.

## Project services

- Public frontend: Vercel
- Backend API: Render
- Database: PostgreSQL
- Source repository: GitHub

## Notes

The project is designed as a practical academic/business project. The public site and admin console communicate through the Spring Boot REST API, while PostgreSQL provides persistent storage for application data.
